package li.allan.domain;

/**
 * Created by alun on 2015/4/16.
 */
public class DeviceType {
	private int id;
	private String name;

	public DeviceType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public DeviceType(int id) {
		this.id = id;
	}

	public DeviceType() {
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
