package li.allan;

import li.allan.domain.Client;
import li.allan.domain.OS;
import li.allan.domain.UserAgent;
import li.allan.domain.Version;
import li.allan.utils.RegexUtils;

import java.util.Map;

public class UAParser {
//    public static void main(String[] args) {
//        System.out.println(parse("|Mozilla/5.0 (iPhone; CPU iPhone OS 8_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12F70 MicroMessenger/6.2.4 NetType/WIFI Language/zh_CN"));
//    }
    public static Client parse(String agentString) {
        OS OS = parseOperationSystem(agentString);
        UserAgent userAgent = parseBrowser(agentString);
        Client client = new Client(OS, userAgent);
        return client;
    }

    public static UserAgent parseBrowser(String userAgent) {
        UserAgent browser = UserAgent.known();
        if (userAgent == null || userAgent.length() == 0) {
            return browser;
        }
        outer:
        for (Map.Entry<String[], UserAgent> osEntry : UAData.getUserAgentMap().entrySet()) {
            for (String regex : osEntry.getKey()) {
                if (RegexUtils.isFind(regex, userAgent)) {
                    browser = (UserAgent) osEntry.getValue().clone();
                    String versionString = RegexUtils.getMatcherCapturedNoException(regex, userAgent);
                    browser.setVersion(parseBrowserVersion(versionString));
                    break outer;
                }
            }
        }
        return browser;
    }

    public static OS parseOperationSystem(String userAgent) {
        OS os = OS.known();
        if (userAgent == null || userAgent.length() == 0) {
            return os;
        }
        outer:
        for (Map.Entry<String[], OS> osEntry : UAData.getOSMap().entrySet()) {
            for (String regex : osEntry.getKey()) {
                if (RegexUtils.isFind(regex, userAgent)) {
                    os = (OS) osEntry.getValue().clone();
                    String versionString = RegexUtils.getMatcherCapturedNoException(regex, userAgent);
                    os.setVersion(parseOperationSystemVersion(versionString, os));
                    break outer;
                }
            }
        }
        return os;
    }

    private static Version parseBrowserVersion(String version) {
        return versionStringFormat(version);
    }

    private static Version parseOperationSystemVersion(String version, OS OS) {
        if (UAData.getOSVersionAliasMap().containsKey(OS.getName())) {
            for (Map.Entry<String, Version> versionAliasEntry : UAData.getOSVersionAliasMap().get(OS.getName()).entrySet()) {
                if (RegexUtils.isMatch(versionAliasEntry.getKey(), version)) {
                    return versionAliasEntry.getValue();
                }
            }
        }
        return versionStringFormat(version);
    }

    private static Version versionStringFormat(String version) {
        String[] versionStrings = RegexUtils.splitByPunctuation(version);
        Version ver = new Version();
        if (versionStrings != null && versionStrings.length != 0) {
            ver.setMajor(versionStrings[0]);
            if (versionStrings.length > 1 && versionStrings[1].length() != 0) {
                ver.setMinor(versionStrings[1]);
            }
            if (versionStrings.length > 2) {
                ver.setRevision(versionStrings[2]);
            }
        }
        return ver;
    }
}
