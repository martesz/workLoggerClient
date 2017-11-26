package entities;

import java.io.Serializable;


/**
 * Entity implementation class for Entity: Project
 *
 */
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;
	private String description;

	public Project() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	
}
