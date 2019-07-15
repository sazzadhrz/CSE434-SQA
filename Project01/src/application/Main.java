package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
		Scene scene = new Scene(mainlayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * private static void generateHeader() throws IOException { String head =
	 * "<head>" + "<title>Resume</title>" + "</head>";
	 * 
	 * File outfile = new File("html/output.html"); BufferedWriter bw = new
	 * BufferedWriter(new FileWriter(outfile)); bw.write(head);
	 * bw.append("appended"); bw.close(); }
	 * 
	 * 
	 * 
	 * public static void overwriteTemplateAndGenerateCV() throws IOException {
	 * File htmlTemplateFile = new File("html/template.html"); String htmlString
	 * = FileUtils.readFileToString(htmlTemplateFile); //
	 * System.out.println(htmlString); String title = "New Page"; String body =
	 * "This is Body"; htmlString = htmlString.replace("$title", title);
	 * htmlString = htmlString.replace("$body", body); //
	 * System.out.println(htmlString);
	 * 
	 * generateCVinHTML(htmlString);
	 * 
	 * }
	 * 
	 * // create a new html file and overwrite the template.html public static
	 * void generateCVinHTML (String htmlString) throws IOException { File
	 * outfile = new File("html/output.html"); BufferedWriter bw = new
	 * BufferedWriter(new FileWriter(outfile)); bw.write(htmlString);
	 * bw.close(); }
	 */

	public static void main(String[] args) throws IOException {
		launch(args);

		generateHTML();

		// overwriteTemplateAndGenerateCV();
	}

	public static void generateHTML() throws IOException {
		arraylist.add(bodyClose());

		File outfile = new File("html/output.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));

		for (int i = 0; i < arraylist.size(); i++) {
			bw.append(arraylist.get(i));
			bw.newLine();
		}

		bw.close();
	}

	private static String bodyClose() {
		return "</body>";
	}

}
