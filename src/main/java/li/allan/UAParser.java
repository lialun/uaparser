package li.allan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import li.allan.domain.BrowserType;
import li.allan.domain.DeviceType;
import li.allan.domain.OperationSystem;
import li.allan.domain.Version;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UAParser {
    private static Map<Integer, BrowserType> browserTypeMap;
    private static Map<Integer, DeviceType> deviceTypeMap;
    private static Map<String, OperationSystem> operationSystemMap;

    static {
        String json = null;
        try {
            json = readFile();
            JSONObject data = JSONObject.parseObject(json);
            //browserType
            browserTypeMap = new HashMap<Integer, BrowserType>();
            for (int i = 0; i < data.getJSONArray("browserType").size(); i++) {
                JSONObject browserType = data.getJSONArray("browserType").getJSONObject(i);
                browserTypeMap.put(browserType.getIntValue("id"), JSON.parseObject(browserType.toJSONString(), BrowserType.class));
            }
            //deviceType
            deviceTypeMap = new HashMap<Integer, DeviceType>();
            for (int i = 0; i < data.getJSONArray("deviceType").size(); i++) {
                JSONObject deviceType = data.getJSONArray("deviceType").getJSONObject(i);
                deviceTypeMap.put(deviceType.getIntValue("id"), JSON.parseObject(deviceType.toJSONString(), DeviceType.class));
            }
            //
            operationSystemMap = new LinkedHashMap<String, OperationSystem>();
            JSONArray operationSystems = data.getJSONArray("operationSystem");
            for (int i = 0; i < operationSystems.size(); i++) {
                JSONObject operationSystem = operationSystems.getJSONObject(i);
                String[] regexs = operationSystem.getString("regex").split("\\|\\|\\|\\|");
                OperationSystem os = new OperationSystem(operationSystem.getString("name"),
                        deviceTypeMap.get(operationSystem.getInteger("deviceType")), null);
                for (String regex : regexs) {
//                    if (!Strings.isNullOrEmpty(regex)) {
                        operationSystemMap.put(regex, os);
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OperationSystem parseOperationSystem(String userAgent) throws CloneNotSupportedException, IOException {
        OperationSystem operationSystem = OperationSystem.known();
        for (String regex : operationSystemMap.keySet()) {
            if (RegexUtils.isMatch(regex, userAgent)) {
                operationSystem = (OperationSystem) operationSystemMap.get(regex).clone();
                String version = RegexUtils.getMatcherCapturedNoException(regex, userAgent);
                operationSystem.setVersion(parseOperationSystemVersion(version, operationSystem));
                break;
            }
        }
        return operationSystem;
    }

    public static Version parseOperationSystemVersion(String version, OperationSystem operationSystem) {
        //TODO OS name alias
        return versionStringFormat(version);
    }

    private static Version versionStringFormat(String version) {
        String[] versionStrings = RegexUtils.splitBy(version);
        Version ver = new Version();
        if (versionStrings != null && versionStrings.length != 0) {
            ver.setMajor(versionStrings[0]);
            if (versionStrings.length > 1) {
                ver.setMinor(versionStrings[1]);
            }
            if (versionStrings.length > 2) {
                ver.setRevision(versionStrings[2]);
            }
        }
        return ver;
    }

    private static String readFile() throws IOException {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("uaparser.json");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        int BUFFER_SIZE = 4096;
        byte[] data = new byte[BUFFER_SIZE];
        int count;
        while ((count = inputStream.read(data, 0, BUFFER_SIZE)) != -1) {
            outStream.write(data, 0, count);
        }
        return new String(outStream.toByteArray(), "UTF-8");
    }
}
