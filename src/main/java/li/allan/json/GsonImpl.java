package li.allan.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Parse source file to Java data format by Gson
 */
public class GsonImpl {
    public static Map<String, List<Map<String, String>>> parseData(String source) throws IOException {
        Type mapType = new TypeToken<Map<String, List<Map<String, String>>>>() {
        }.getType();
        return new Gson().fromJson(source, mapType);
    }
}
