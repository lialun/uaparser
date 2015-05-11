package li.allan.domain;

public class Browser {
    private String name;
    private Version version;
    private BrowserType browserType;

    public Browser(String name, Version version) {
        this(name, version, null);
    }

    public Browser(String name, Version version, BrowserType browserType) {
        this.name = name;
        this.version = version;
        this.browserType = browserType;
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
}
