package application;

import entities.WorkingHour;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class WorkingHourList {
	public static Callback<ListView<WorkingHour>, ListCell<WorkingHour>> createCellFactory() {
		return new Callback<ListView<WorkingHour>, ListCell<WorkingHour>>() {

			@Override
			public ListCell<WorkingHour> call(ListView<WorkingHour> p) {

				ListCell<WorkingHour> cell = new ListCell<WorkingHour>() {

					@Override
					protected void updateItem(WorkingHour workingHour, boolean bln) {
						super.updateItem(workingHour, bln);
						if (workingHour != null) {
							setText("Issue: " + workingHour.getIssue().getName() + " start: " + workingHour.getStarting()
									+ " duration: " + workingHour.getDuration());
						}
					}

				};

				return cell;
			}
		};
	}

}
