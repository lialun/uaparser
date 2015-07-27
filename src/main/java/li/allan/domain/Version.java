package li.allan.domain;

public class Version {
    public String major;
    public String minor;
    public String revision;

    public Version() {
    }

    public Version(String major, String minor, String revision) {
        this.major = major;
        this.minor = minor;
        this.revision = revision;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major != null) {
            this.major = major;
        }
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        if (minor != null) {
            this.minor = minor;
        }
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        if (revision != null) {
            this.revision = revision;
        }
    }

    @Override
    public String toString() {
        return "Version{" +
                "major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", revision='" + revision + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Version)) return false;

        Version version = (Version) o;

        if (major != null ? !major.equals(version.major) : version.major != null) return false;
        if (minor != null ? !minor.equals(version.minor) : version.minor != null) return false;
        return !(revision != null ? !revision.equals(version.revision) : version.revision != null);

    }

    @Override
    public int hashCode() {
        int result = major != null ? major.hashCode() : 0;
        result = 31 * result + (minor != null ? minor.hashCode() : 0);
        result = 31 * result + (revision != null ? revision.hashCode() : 0);
        return result;
    }
}
