package entities;

public class Person {

	private long id;

	private String name;

	private String position;

	public static Person from(String name, String position) {
		Person person = new Person();
		person.name = name;
		person.position = position;
		return person;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public long getId() {
		return id;
	}

}
