package li.allan.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Parse source file to Java data format by jackson
 */
public class JacksonImpl {
    public static Map<String, List<Map<String, String>>> parseData(String source) throws IOException {
        return new ObjectMapper().readValue(source, new TypeReference<Map<String, List<Map<String, String>>>>() {
        });
    }
}
