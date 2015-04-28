package li.allan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import li.allan.domain.*;
import li.allan.exception.UAParserException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UAData {

    private static boolean isLoad = false;
    private static Map<String, Browser> browserMap;
    private static Map<String, OperationSystem> operationSystemMap;
    private static Map<Integer, OperationSystemVersionAlias> operationSystemVersionAliasMap;

    static {
        load();
    }

    private static void load() {
        if (!isLoad) {
            synchronized (UAData.class) {
                if (!isLoad) {
                    try {
                        String source = readFromResources("uaparser.json1");
                        JSON_PACKAGE jsonPackage = findJsonPackage();
                        if (jsonPackage.equals(JSON_PACKAGE.FASTJSON)) {
                            parseByFastJson(source);
                        } else if (jsonPackage.equals(JSON_PACKAGE.JACKSON)) {

                        } else {

                        }
                        isLoad = true;
                    } catch (Exception e) {
                        throw new UAParserException("ERROR loading UAParser data file", e);
                    }
                }
            }
        }
    }

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

    /**
     * parse data file by fastjson
     *
     * @param source
     */
    private static void parseByFastJson(String source) {
        JSONObject data = JSONObject.parseObject(source);
        //browserType
        Map<Integer, BrowserType> browserTypeMap = new HashMap<Integer, BrowserType>();
        for (int i = 0; i < data.getJSONArray("browserType").size(); i++) {
            JSONObject browserType = data.getJSONArray("browserType").getJSONObject(i);
            browserTypeMap.put(browserType.getIntValue("id"), JSON.parseObject(browserType.toJSONString(), BrowserType.class));
        }
        //deviceType
        Map<Integer, DeviceType> deviceTypeMap = new HashMap<Integer, DeviceType>();
        for (int i = 0; i < data.getJSONArray("deviceType").size(); i++) {
            JSONObject deviceType = data.getJSONArray("deviceType").getJSONObject(i);
            deviceTypeMap.put(deviceType.getIntValue("id"), JSON.parseObject(deviceType.toJSONString(), DeviceType.class));
        }
        //operationSystem
        operationSystemMap = new LinkedHashMap<String, OperationSystem>();
        JSONArray operationSystems = data.getJSONArray("operationSystem");
        for (int i = 0; i < operationSystems.size(); i++) {
            JSONObject operationSystem = operationSystems.getJSONObject(i);
            String[] regexs = operationSystem.getString("regex").split("\\|\\|\\|\\|");
            OperationSystem os = new OperationSystem(operationSystem.getString("name"),
                    deviceTypeMap.get(operationSystem.getInteger("deviceType")), null);
            for (String regex : regexs) {
                operationSystemMap.put(regex, os);
            }
        }
    }

    /**
     * find the json parser package which has import
     *
     * @return
     * @throws ClassNotFoundException
     */
    private static JSON_PACKAGE findJsonPackage() throws ClassNotFoundException {
        try {
            Class.forName("com.alibaba.fastjson.JSONObject");
            return JSON_PACKAGE.FASTJSON;
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("jaskson");
            return JSON_PACKAGE.JACKSON;
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("org.json.JSONObject");
            return JSON_PACKAGE.ORG_JSON;
        } catch (ClassNotFoundException e) {
        }
        throw new ClassNotFoundException("you mast import one of fastjson,jackson,org.json");
    }

    private enum JSON_PACKAGE {
        FASTJSON, JACKSON, ORG_JSON;
    }
}
