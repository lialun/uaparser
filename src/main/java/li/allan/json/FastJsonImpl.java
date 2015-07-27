package li.allan.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Parse source file to Java data format by FastJson
 */
public class FastJsonImpl {
    public static Map<String, List<Map<String, String>>> parseData(String source) throws IOException {
        return JSON.parseObject(source, new TypeReference<Map<String, List<Map<String, String>>>>() {
        });
    }
}
