package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

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
	
	public static void baal() throws IOException {
		File htmlTemplateFile = new File("html/template.html");
		String htmlString = FileUtils.readFileToString(htmlTemplateFile);
		System.out.println(htmlString);
		String title = "New Page";
		String body = "This is Body";
		htmlString = htmlString.replace("$title", title);
		htmlString = htmlString.replace("$body", body);
		System.out.println(htmlString);
		
		File outfile = new File("html/output.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
		bw.write(htmlString);
		bw.close();
	}
	
	public static void main(String[] args) {
		launch(args);
		try {
			baal();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
