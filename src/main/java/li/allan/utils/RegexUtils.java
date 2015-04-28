package li.allan.utils;

import com.sun.istack.internal.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

	/**
	 * use regex to get the first group string
	 *
	 * @param regex
	 * @param source
	 * @return first group or exception
	 */
	public static String getMatcherCaptured(@NotNull String regex,@NotNull  String source) {
		String result = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		while (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}

	/**
	 * use regex to get the first group string
	 * @param regex
	 * @param source
	 * @return first group or ""
	 */
	public static String getMatcherCapturedNoException(@NotNull String regex,@NotNull  String source) {
		try {
			return getMatcherCaptured(regex, source);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * use regex to judge if match
	 *
	 * @param regex
	 * @param source
	 * @return
	 */
	public static boolean isMatch(@NotNull String regex,@NotNull  String source) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * split a string by punctuation,use to resolve version string.
	 * @param source
	 * @return
	 */
	public static String[] splitByPunctuation(@NotNull String source) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		return pattern.split(source);
	}

}

