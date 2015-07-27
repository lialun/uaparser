package li.allan.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    /**
     * use regex to get the first group string
     *
     * @param regex regex
     * @param source source
     * @return first group or exception
     */
    public static String getMatcherCaptured(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    /**
     * use regex to get the first group string
     *
     * @param regex regex
     * @param source source
     * @return first group or ""
     */
    public static String getMatcherCapturedNoException(String regex, String source) {
        try {
            return getMatcherCaptured(regex, source);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * use regex to judge if match
     *
     * @param regex regex
     * @param source source
     * @return
     */
    public static boolean isMatch(String regex, String source) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * use regex to judge if match
     *
     * @param regex regex
     * @param source source
     * @return
     */
    public static boolean isFind(String regex, String source) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return matcher.find();
    }

    /**
     * split a string by punctuation,use to resolve version string.
     *
     * @param source source
     * @return
     */
    public static String[] splitByPunctuation(String source) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        return pattern.split(source);
    }

}

