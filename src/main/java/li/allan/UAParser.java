package li.allan;

import li.allan.domain.Client;
import li.allan.domain.OperationSystem;
import li.allan.domain.UserAgent;
import li.allan.domain.Version;
import li.allan.utils.RegexUtils;

import java.util.Map;

public class UAParser {

    public static Client parse(String agentString) {
        OperationSystem operationSystem = parseOperationSystem(agentString);
        UserAgent userAgent = parseBrowser(agentString);
        Client client = new Client(operationSystem, userAgent);
        return client;
    }

    public static UserAgent parseBrowser(String userAgent) {
        UserAgent browser = UserAgent.known();
        for (Map.Entry<String[], UserAgent> osEntry : UAData.getUserAgentMap().entrySet()) {
            for (String regex : osEntry.getKey()) {
                if (RegexUtils.isFind(regex, userAgent)) {
                    browser = (UserAgent) osEntry.getValue().clone();
                    String versionString = RegexUtils.getMatcherCapturedNoException(regex, userAgent);
                    browser.setVersion(parseBrowserVersion(versionString));
                    break;
                }
            }
        }
        return browser;
    }

    public static OperationSystem parseOperationSystem(String userAgent) {
        OperationSystem operationSystem = OperationSystem.known();
        for (Map.Entry<String[], OperationSystem> osEntry : UAData.getOperationSystemMap().entrySet()) {
            for (String regex : osEntry.getKey()) {
                if (RegexUtils.isFind(regex, userAgent)) {
                    operationSystem = (OperationSystem) osEntry.getValue().clone();
                    String versionString = RegexUtils.getMatcherCapturedNoException(regex, userAgent);
                    operationSystem.setVersion(parseOperationSystemVersion(versionString, operationSystem));
                    break;
                }
            }
        }
        return operationSystem;
    }

    private static Version parseBrowserVersion(String version) {
        return versionStringFormat(version);
    }

    private static Version parseOperationSystemVersion(String version, OperationSystem operationSystem) {
        if (UAData.getOperationSystemVersionAliasMap().containsKey(operationSystem.getName())) {
            for (Map.Entry<String, Version> versionAliasEntry : UAData.getOperationSystemVersionAliasMap().get(operationSystem.getName()).entrySet()) {
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
