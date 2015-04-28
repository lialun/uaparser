package li.allan.domain;

public class OperationSystemVersionAlias {
    int operationSystemId;
    String regex;
    Version version;

    public OperationSystemVersionAlias(int operationSystemId, String regex, Version version) {
        this.operationSystemId = operationSystemId;
        this.regex = regex;
        this.version = version;
    }

    public int getOperationSystemId() {
        return operationSystemId;
    }

    public void setOperationSystemId(int operationSystemId) {
        this.operationSystemId = operationSystemId;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }
}
