package li.allan.domain;

import li.allan.Constants;

public class OS implements Cloneable {
    private String name;
    private DeviceType deviceType;
    private Version version;

    public OS(String name, DeviceType deviceType) {
        this.name = name;
        this.deviceType = deviceType;
    }

    public static OS known() {
        return new OS(Constants.KNOWN, null);
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
        return "OS{" +
                "name='" + name + '\'' +
                ", deviceType=" + deviceType +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OS)) return false;

        OS that = (OS) o;

        if (!name.equals(that.name)) return false;
        if (deviceType != null ? !deviceType.equals(that.deviceType) : that.deviceType != null)
            return false;
        return !(version != null ? !version.equals(that.version) : that.version != null);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() {
        OS cloneObj = null;
        try {
            cloneObj = (OS) super.clone();
        } catch (CloneNotSupportedException e) {
            // impossible,do nothing
        }
        return cloneObj;
    }
}
