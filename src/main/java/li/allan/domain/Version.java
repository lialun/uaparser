package li.allan.domain;

public class Version {
    private String major;
    private String minor;
    private String revision;
    private String codeName;

    public Version() {
    }

    public Version(String major, String minor, String revision, String codeName) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "Version{" +
                "major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", revision='" + revision + '\'' +
                ", codeName='" + codeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (major != null ? !major.equals(version.major) : version.major != null) return false;
        if (minor != null ? !minor.equals(version.minor) : version.minor != null) return false;
        if (revision != null ? !revision.equals(version.revision) : version.revision != null) return false;
        return !(codeName != null ? !codeName.equals(version.codeName) : version.codeName != null);

    }

    @Override
    public int hashCode() {
        int result = major != null ? major.hashCode() : 0;
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (revision != null ? revision.hashCode() : 0);
        result = 31 * result + (codeName != null ? codeName.hashCode() : 0);
        return result;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null) {
            this.major = "";
        } else {
            this.major = major;
        }
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        if (minor == null) {
            this.minor = "";
        } else {
            this.minor = minor;
        }
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        if (revision == null) {
            this.revision = "";
        } else {
            this.revision = revision;
        }
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        if (codeName == null) {
            this.codeName = "";
        } else {
            this.codeName = codeName;
        }
    }
}
