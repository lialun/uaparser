package li.allan.utils;

import com.sun.istack.internal.Nullable;

public class UAParserUtils {

    public static boolean isBlankString(@Nullable String string) {
        return string == null || string.isEmpty();
    }

    public static String nullToEmpty(@Nullable String string) {
        return (string == null) ? "" : string;
    }

    @Nullable
    public static String emptyToNull(@Nullable String string) {
        return isBlankString(string) ? null : string;
    }

}
