package application;

import java.util.List;

import com.google.api.client.auth.oauth2.Credential;

import entities.Report;
import entities.WorkingHour;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rest.LoginClient;
import rest.ReportClient;
import rest.WorkingHoursClient;

public class Main extends Application {

	private Button workingHours, googleLogin, report, backToMenu;
	private String googleId;
	private Scene loginScene, menuScene, reportsScene, workingHoursScene;
	private BorderPane loginPane, menuPane, reportsPane, workingHoursPane;

	@Override
	public void start(Stage primaryStage) {
		try {
			initScenes();
			primaryStage.setTitle("Work logger client");
			primaryStage.setScene(loginScene);

			googleLogin = new Button("Login with Google");
			googleLogin.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					try {
						Credential credential = GoogleClient.authorize();
						String userId = LoginClient.getUserId(credential.getAccessToken());
						googleId = userId;
						primaryStage.setScene(menuScene);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			});

			backToMenu = new Button("Back to menu");
			backToMenu.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					primaryStage.setScene(menuScene);
				}
			});

			report = new Button("Show reports");
			report.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					List<Report> reports = ReportClient.getReports(googleId);
					ListView<Report> listView = new ListView<>();
					ObservableList<Report> myObservableList = FXCollections.observableList(reports);
					listView.setItems(myObservableList);
					listView.setCellFactory(ReportList.createCellFactory());
					reportsPane.setTop(backToMenu);
					reportsPane.setBottom(listView);
					primaryStage.setScene(reportsScene);
				}
			});

			workingHours = new Button("Show working hours");
			workingHours.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					List<WorkingHour> workingHours = WorkingHoursClient.getWorkingHours(googleId);
					ListView<WorkingHour> listView = new ListView<>();
					ObservableList<WorkingHour> myObservableList = FXCollections.observableList(workingHours);
					listView.setItems(myObservableList);
					listView.setCellFactory(WorkingHourList.createCellFactory());
					workingHoursPane.setTop(backToMenu);
					workingHoursPane.setBottom(listView);
					primaryStage.setScene(workingHoursScene);
				}
			});

			menuPane.setTop(report);
			menuPane.setBottom(workingHours);

			loginPane.setTop(googleLogin);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initScenes() {
		loginPane = new BorderPane();
		reportsPane = new BorderPane();
		menuPane = new BorderPane();
		workingHoursPane = new BorderPane();
		loginPane.setId("grid-pane");
		loginPane.getStyleClass().add("pane-styles");
		loginScene = new Scene(loginPane, 200, 100);
		menuScene = new Scene(menuPane, 200, 100);
		reportsScene = new Scene(reportsPane, 400, 400);
		workingHoursScene = new Scene(workingHoursPane, 500, 400);
		loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
