package entities;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: User
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2L;

	private String googleId;
	private String name;

	private Level level;
	
	public enum Level {
		EMPLOYEE, PROJECT_LEADER, ADMIN
	}
	
	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setLevelFromString(String level) {
		this.level = Level.valueOf(level);
	}

	@Override
	public String toString() {
		return "User [googleId=" + googleId + ", name=" + name + ", level=" + level + "]";
	}

}
