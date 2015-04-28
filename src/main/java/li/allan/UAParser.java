package li.allan;

import li.allan.domain.OperationSystem;
import li.allan.domain.OperationSystemVersionAlias;
import li.allan.domain.Version;
import li.allan.utils.RegexUtils;

import java.util.Map;

public class UAParser {
    public static void main(String[] args) {
        System.out.print(parseOperationSystem("Windows NT 6.2"));
    }

    public static OperationSystem parseOperationSystem(String userAgent) {
        OperationSystem operationSystem = OperationSystem.known();
        for (Map.Entry<String, OperationSystem> osEntry : UAData.getOperationSystemMap().entrySet()) {
            if (RegexUtils.isMatch(osEntry.getKey(), userAgent)) {
                operationSystem = (OperationSystem) osEntry.getValue().clone();
                String versionString = RegexUtils.getMatcherCapturedNoException(osEntry.getKey(), userAgent);
                operationSystem.setVersion(parseOperationSystemVersion(versionString, operationSystem));
                break;
            }
        }
        return operationSystem;
    }

    private static Version parseOperationSystemVersion(String version, OperationSystem operationSystem) {
        if (UAData.getOperationSystemVersionAliasMap().containsKey(operationSystem.getId())) {
            for (OperationSystemVersionAlias alias : UAData.getOperationSystemVersionAliasMap().get(operationSystem.getId())) {
                if (RegexUtils.isMatch(alias.getRegex(), version)) {
                    return alias.getVersion();
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
            if (versionStrings.length > 1) {
                ver.setMinor(versionStrings[1]);
            }
            if (versionStrings.length > 2) {
                ver.setRevision(versionStrings[2]);
            }
        }
        return ver;
    }
}
