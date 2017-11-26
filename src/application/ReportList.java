package application;

import entities.Report;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ReportList {
	public static Callback<ListView<Report>, ListCell<Report>> createCellFactory() {
		return new Callback<ListView<Report>, ListCell<Report>>() {

			@Override
			public ListCell<Report> call(ListView<Report> p) {

				ListCell<Report> cell = new ListCell<Report>() {

					@Override
					protected void updateItem(Report report, boolean bln) {
						super.updateItem(report, bln);
						if (report != null) {
							setText("Type: " + report.getReportType() + " Start: " + report.getStartDate());
						}
					}

				};

				return cell;
			}
		};
	}
}
