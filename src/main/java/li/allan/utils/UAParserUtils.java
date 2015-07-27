package li.allan.utils;

public class UAParserUtils {

    public static boolean isBlankString(String string) {
        return string == null || string.isEmpty();
    }

    public static String nullToEmpty(String string) {
        return (string == null) ? "" : string;
    }


    public static String emptyToNull(String string) {
        return isBlankString(string) ? null : string;
    }

}
