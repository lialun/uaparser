package li.allan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import li.allan.domain.*;
import li.allan.json.FastJsonImpl;
import li.allan.json.GsonImpl;
import li.allan.json.JacksonImpl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
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

    public static Map<String[], OperationSystem> getOperationSystemMap() {
        return getInstance().operationSystemMap;
    }

    public static Map<String, Map<String, Version>> getOperationSystemVersionAliasMap() {
        return getInstance().operationSystemVersionAliasMap;
    }

    private Map<String[], UserAgent> userAgentMap;//Map<regex[], useragent>
    private Map<String[], OperationSystem> operationSystemMap;//Map<regex[],os>
    private Map<String, Map<String, Version>> operationSystemVersionAliasMap;//Map<osName, Map<versionRegex,Version>>

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

    private void parseByGson(String source) throws IOException {
        Type mapType = new TypeToken<Map<String, List<Map<String, String>>>>() {
        }.getType();
        Map<String, List<Map<String, String>>> data = new Gson().fromJson(source, mapType);
        load(data);
    }

    private void load(Map<String, List<Map<String, String>>> data) {
        //browserType
        Map<Integer, BrowserType> browserTypeMap = new HashMap<Integer, BrowserType>();
        for (int i = 0; i < data.get("browserType").size(); i++) {
            Map<String, String> tmp = data.get("browserType").get(i);
            System.out.print(Integer.valueOf(tmp.get("id")));
            browserTypeMap.put(Integer.valueOf(tmp.get("id")), new BrowserType(Integer.valueOf(tmp.get("id")), tmp.get("name")));
        }
        //browser
        userAgentMap = new LinkedHashMap<String[], UserAgent>();
        for (int i = 0; i < data.get("browser").size(); i++) {
            Map<String, String> tmp = data.get("browser").get(i);
            String[] regexs = tmp.get("regex").toString().split("\\|\\|\\|\\|");
            UserAgent b = new UserAgent(tmp.get("name"), browserTypeMap.get(tmp.get("browserType")), tmp.get("homepage"));
            userAgentMap.put(regexs, b);
        }
        //deviceType
        Map<Integer, DeviceType> deviceTypeMap = new HashMap<Integer, DeviceType>();
        for (int i = 0; i < data.get("deviceType").size(); i++) {
            Map<String, String> tmp = data.get("deviceType").get(i);
            deviceTypeMap.put(Integer.valueOf(tmp.get("id")), new DeviceType(Integer.valueOf(tmp.get("id")), (String) tmp.get("name")));
        }
        //operationSystem
        operationSystemMap = new LinkedHashMap<String[], OperationSystem>();
        for (int i = 0; i < data.get("operationSystem").size(); i++) {
            Map<String, String> tmp = data.get("operationSystem").get(i);
            String[] regexs = tmp.get("regex").toString().split("\\|\\|\\|\\|");
            OperationSystem os = new OperationSystem(tmp.get("name"), deviceTypeMap.get(tmp.get("deviceType")));
            operationSystemMap.put(regexs, os);
        }
        //operationSystem version alias
        operationSystemVersionAliasMap = new HashMap<String, Map<String, Version>>();
        for (int i = 0; i < data.get("operationSystemVersionAliases").size(); i++) {
            Map<String, String> tmp = data.get("operationSystemVersionAliases").get(i);
            if (!operationSystemVersionAliasMap.containsKey(tmp.get("os"))) {
                operationSystemVersionAliasMap.put(tmp.get("os"), new HashMap<String, Version>());
            }
            Version version = new Version(tmp.get("major"), tmp.get("minor"), tmp.get("revision"));
            operationSystemVersionAliasMap.get(tmp.get("os")).put(tmp.get("regex"), version);
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
