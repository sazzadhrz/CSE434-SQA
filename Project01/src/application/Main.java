package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	public static ArrayList<String> arraylist = new ArrayList<String>();

	private StackPane mainlayout;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			primaryStage.setTitle("Resume Generator");
			showIntroductionView();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showIntroductionView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Introduction.fxml"));
		mainlayout = loader.load();
		// mainlayout.setMargin(mainlayout, new Insets(50,50,50,50));
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) throws IOException {
		launch(args);
	}

}
