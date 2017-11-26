package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: WorkingHour
 *
 */
public class WorkingHour implements Serializable {

	private long id;

	private Date starting;
	private long duration;
	private User user;
	private Issue issue;

	private static final long serialVersionUID = 1L;

	public WorkingHour() {
		super();
	}

	public Date getStarting() {
		return starting;
	}

	public void setStarting(Date starting) {
		this.starting = starting;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "WorkingHour [id=" + id + ", starting=" + starting + ", duration=" + duration + ", user=" + user
				+ ", issue=" + issue + "]";
	}

}
