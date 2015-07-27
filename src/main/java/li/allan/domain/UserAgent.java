package li.allan.domain;

import li.allan.Constants;

public class UserAgent implements Cloneable {
    private String name;
    private Version version;
    private BrowserType browserType;
    private String homepage;

    public UserAgent(String name, BrowserType browserType, String homepage) {
        this.name = name;
        this.browserType = browserType;
        this.homepage = homepage;
    }

    public static UserAgent known() {
        return new UserAgent(Constants.KNOWN, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", browserType=" + browserType +
                '}';
    }

    @Override
    public Object clone() {
        UserAgent cloneObj = null;
        try {
            cloneObj = (UserAgent) super.clone();
        } catch (CloneNotSupportedException e) {
            // impossible,do nothing
        }
        return cloneObj;
    }
}
