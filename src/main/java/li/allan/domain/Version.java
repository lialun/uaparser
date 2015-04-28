package li.allan.domain;

import li.allan.UAParserUtils;

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
        if (!UAParserUtils.nullToEmpty(major).equals(UAParserUtils.nullToEmpty(version.major))) return false;
        if (!UAParserUtils.nullToEmpty(minor).equals(UAParserUtils.nullToEmpty(version.minor))) return false;
        if (!UAParserUtils.nullToEmpty(revision).equals(UAParserUtils.nullToEmpty(version.revision))) return false;
        return (!UAParserUtils.nullToEmpty(codeName).equals(UAParserUtils.nullToEmpty(version.codeName)));
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
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
