package li.allan.domain;

public class OperationSystem implements Cloneable {
    private int id;
    private String name;
    private DeviceType deviceType;
    private Version version;

    public OperationSystem(String name, Version version) {
        this(0, name, null, version);
    }

    public OperationSystem(int id, String name, DeviceType deviceType, Version version) {
        this.id = id;
        this.name = name;
        this.deviceType = deviceType;
        this.version = version;
    }

    public static OperationSystem known() {
        return new OperationSystem(0, "known", null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", deviceType=" + deviceType +
                ", version=" + version +
                '}';
    }


    @Override
    public Object clone() {
        OperationSystem cloneObj = null;
        try {
            cloneObj = (OperationSystem) super.clone();
        } catch (CloneNotSupportedException e) {
            // impossible,do nothing
        }
        return cloneObj;
    }
}
