package li.allan.domain;

public class Client {
    public final OperationSystem operationSystem;
    public final UserAgent userAgent;

    public Client(OperationSystem operationSystem, UserAgent userAgent) {
        this.operationSystem = operationSystem;
        this.userAgent = userAgent;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "operationSystem=" + operationSystem +
                ", userAgent=" + userAgent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!operationSystem.equals(client.operationSystem)) return false;
        return userAgent.equals(client.userAgent);

    }

    @Override
    public int hashCode() {
        int result = operationSystem.hashCode();
        result = 31 * result + userAgent.hashCode();
        return result;
    }
}
