package li.allan.domain;

public class Client {
    public final OS OS;
    public final UserAgent userAgent;

    public Client(OS OS, UserAgent userAgent) {
        this.OS = OS;
        this.userAgent = userAgent;
    }

    public OS getOS() {
        return OS;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "OS=" + OS +
                ", userAgent=" + userAgent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!OS.equals(client.OS)) return false;
        return userAgent.equals(client.userAgent);

    }

    @Override
    public int hashCode() {
        int result = OS.hashCode();
        result = 31 * result + userAgent.hashCode();
        return result;
    }
}
