package li.allan.domain;

public class DeviceType {
	public int id;
	public String name;

	public DeviceType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof DeviceType))
			return false;

		DeviceType that = (DeviceType) o;

		if (id != that.id)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "DeviceType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
