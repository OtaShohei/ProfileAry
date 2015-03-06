package jp.egaonohon.ota.profile;

public class Member {
	private String name;
	private String prof;
	private int id;

	public Member(String name, String prof, int id) {
		super();
		this.name = name;
		this.prof = prof;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
