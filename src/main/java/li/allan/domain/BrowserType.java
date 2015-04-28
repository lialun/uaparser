package li.allan.domain;

/**
 * Created by alun on 2015/4/15.
 */
public class BrowserType {
	int id;
	String name;

	public BrowserType() {
	}

	BrowserType(int id, String name) {
		this.id = id;
		this.name = name;
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
}
