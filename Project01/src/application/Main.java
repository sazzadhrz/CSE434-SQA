package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	private StackPane mainlayout;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {	
			this.primaryStage = primaryStage;
			primaryStage.setTitle("Resume Generator");
			showIntroductionView();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showIntroductionView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Introduction.fxml"));
		mainlayout = loader.load();
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
