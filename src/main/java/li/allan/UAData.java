package li.allan;

import li.allan.domain.*;
import li.allan.json.FastJsonImpl;
import li.allan.json.GsonImpl;
import li.allan.json.JacksonImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class UAData {
    private static UAData uaData;

    private UAData(String configPath) {
        try {
            String source = readFromResources(configPath);
            JSON_PACKAGE jsonPackage = findJsonPackage();
            if (jsonPackage.equals(JSON_PACKAGE.FASTJSON)) {
                load(FastJsonImpl.parseData(source));
            } else if (jsonPackage.equals(JSON_PACKAGE.JACKSON)) {
                load(JacksonImpl.parseData(source));
            } else {
                load(GsonImpl.parseData(source));
            }
        } catch (IOException e) {
            throw new RuntimeException("ERROR loading UAparser data file", e);
        }
    }

    private static UAData getInstance() {
        if (uaData == null) {
            uaData = new UAData("uaparser.json");
        }
        return uaData;
    }

    public static Map<String[], UserAgent> getUserAgentMap() {
        return getInstance().userAgentMap;
    }

    public static Map<String[], OS> getOSMap() {
        return getInstance().OSMap;
    }

    public static Map<String, Map<String, Version>> getOSVersionAliasMap() {
        return getInstance().OSVersionAliasMap;
    }

    private Map<String[], UserAgent> userAgentMap;//Map<regex[], useragent>
    private Map<String[], OS> OSMap;//Map<regex[],os>
    private Map<String, Map<String, Version>> OSVersionAliasMap;//Map<osName, Map<versionRegex,Version>>

    private static String readFromResources(String path) throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int BUFFER_SIZE = 4096;
        byte[] data = new byte[BUFFER_SIZE];
        int count;
        while ((count = inputStream.read(data, 0, BUFFER_SIZE)) != -1) {
            outStream.write(data, 0, count);
        }
        return new String(outStream.toByteArray(), "UTF-8");
    }

    private void load(Map<String, List<Map<String, String>>> data) {
        //agentType
        Map<Integer, BrowserType> browserTypeMap = new HashMap<Integer, BrowserType>();
        for (int i = 0; i < data.get("agentType").size(); i++) {
            Map<String, String> tmp = data.get("agentType").get(i);
            browserTypeMap.put(Integer.valueOf(tmp.get("id")), new BrowserType(Integer.valueOf(tmp.get("id")), tmp.get("name")));
        }
        //agent
        userAgentMap = new LinkedHashMap<String[], UserAgent>();
        for (int i = 0; i < data.get("agent").size(); i++) {
            Map<String, String> tmp = data.get("agent").get(i);
            String[] regexs = tmp.get("regex").toString().split("\\|\\|\\|\\|");
            UserAgent b = new UserAgent(tmp.get("name"), browserTypeMap.get(tmp.get("type")), tmp.get("homepage"));
            userAgentMap.put(regexs, b);
        }
        //deviceType
        Map<Integer, DeviceType> deviceTypeMap = new HashMap<Integer, DeviceType>();
        for (int i = 0; i < data.get("deviceType").size(); i++) {
            Map<String, String> tmp = data.get("deviceType").get(i);
            deviceTypeMap.put(Integer.valueOf(tmp.get("id")), new DeviceType(Integer.valueOf(tmp.get("id")), (String) tmp.get("name")));
        }
        //OS
        OSMap = new LinkedHashMap<String[], OS>();
        for (int i = 0; i < data.get("os").size(); i++) {
            Map<String, String> tmp = data.get("os").get(i);
            String[] regexs = tmp.get("regex").toString().split("\\|\\|\\|\\|");
            OS os = new OS(tmp.get("name"), deviceTypeMap.get(tmp.get("deviceType")));
            OSMap.put(regexs, os);
        }
        //OS version alias
        OSVersionAliasMap = new HashMap<String, Map<String, Version>>();
        for (int i = 0; i < data.get("oSVersionAliases").size(); i++) {
            Map<String, String> tmp = data.get("oSVersionAliases").get(i);
            if (!OSVersionAliasMap.containsKey(tmp.get("os"))) {
                OSVersionAliasMap.put(tmp.get("os"), new HashMap<String, Version>());
            }
            Version version = new Version(tmp.get("major"), tmp.get("minor"), tmp.get("revision"));
            OSVersionAliasMap.get(tmp.get("os")).put(tmp.get("regex"), version);
        }
    }

    /**
     * find the json parser package which has import
     *
     * @return
     * @throws ClassNotFoundException
     */
    private JSON_PACKAGE findJsonPackage() {
        try {
            Class.forName("com.alibaba.fastjson.JSONObject");
            return JSON_PACKAGE.FASTJSON;
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("com.fasterxml.jackson.databind.ObjectMapper");
            return JSON_PACKAGE.JACKSON;
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("com.google.gson.Gson");
            return JSON_PACKAGE.GSON;
        } catch (ClassNotFoundException e) {
        }
        throw new RuntimeException("you must import one of FastJson, Jackson2.x, Gson");
    }

    enum JSON_PACKAGE {
        FASTJSON, JACKSON, GSON
    }


}
