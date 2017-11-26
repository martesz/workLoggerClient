package entities;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: Report
 *
 */
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private User owner;
	private String googleId;
	private ReportType reportType;
	private Date startDate;

	public enum ReportType {
		DAILY(1), WEEKLY(7), MONTHLY(30);

		private int lengthDays;

		private ReportType(int lengthDays) {
			this.lengthDays = lengthDays;
		}

		public int getLengthDays() {
			return lengthDays;
		}
	}

	public Report() {
		super();
	}

	public String getGoogleId() {
		return googleId;
	}
	
	public ReportType getReportType() {
		return reportType;
	}

	public void setReportType(final ReportType reportType) {
		this.reportType = reportType;
	}

	public long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", owner=" + owner + ", googleId=" + googleId + ", reportType=" + reportType
				+ ", startDate=" + startDate + "]";
	}
	
}