package li.allan.domain;

public class OperationSystem implements Cloneable {
    private int id;
    private String name;
    private DeviceType deviceType;
    private Version version;

    public OperationSystem() {
    }

    public OperationSystem(String name, DeviceType deviceType, Version version) {
        this.name = name;
        this.deviceType = deviceType;
        this.version = version;
    }

    public static OperationSystem known() {
        return new OperationSystem("known", null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OperationSystem{" +
                "name='" + name + '\'' +
                ", deviceType=" + deviceType +
                ", version=" + version +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (OperationSystem) super.clone();
    }
}
