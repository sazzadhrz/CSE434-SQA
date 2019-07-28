package application.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class OthersController {
	@FXML
	private VBox otherslayout;
	@FXML
	private TextArea skillsTA;
	@FXML
	private TextArea interestsTA;
	@FXML
	private Label warningLabel;
	@FXML
	private Button back;
	@FXML
	private Button cancel;
	@FXML
	private Button generateCV;
	
	public static String othersHTML;

	// Event Listener on Button[#back].onAction
	@FXML
	public void othersBackBtnController(ActionEvent event) throws IOException {
		System.out.println("others back btn pressed");
		WorkController.workHTML = null;
		goToWork();
	}

	// Event Listener on Button[#cancel].onAction
	@FXML
	public void othersCancelBtnController(ActionEvent event) {
		System.out.println("Cancel btn pressed");
		exit();
	}

	// Event Listener on Button[#generateCV].onAction
	@FXML
	public void othersGenerateCvBtnController(ActionEvent event) throws IOException {
		System.out.println("generateResume button pressed");
		next();
	}
	
	public void next() throws IOException {
		 if (fieldValidation()) {
			 System.out.println("validation done");
			 storeData();
			 addToMainList();
			 generateResume();
			 exit();
			 }
	}
	
	public static void generateResume() throws IOException {
		Main.arraylist.add(bodyClose());

		File outfile = new File("html/resume.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));

		for (int i = 0; i < Main.arraylist.size(); i++) {
			bw.append(Main.arraylist.get(i));
			bw.newLine();
		}

		bw.close();
	}
	
	private static String bodyClose() {
		return "</body>";
	}
	
	public void storeData() {
		othersHTML = generateOthersHTML();
		//Main.arraylist.add(workHTML);
	}
	
	public void addToMainList() {
		Main.arraylist.add("<br>");
		Main.arraylist.add(EducationController.educationHtml);
		Main.arraylist.add("<br>");
		Main.arraylist.add(WorkController.workHTML);
		Main.arraylist.add("<br>");
		Main.arraylist.add(OthersController.othersHTML);
	}
	

	public void exit() {
		Platform.exit();
		System.exit(0);
	}

	public void goToWork() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Work.fxml"));
		otherslayout.getChildren().setAll(pane);
	}

	public boolean fieldValidation() {
		return
		skillsTAFieldValidation() &&
		interestsTAFieldValidation();
	}

	public boolean skillsTAFieldValidation() {
		if (skillsTA.getText() == "null" || skillsTA.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, skills null");
			return false;
		}

		else {
			System.out.println(skillsTA.getText());			
			return true;
		}

	}

	public boolean interestsTAFieldValidation() {
		if (interestsTA.getText() == "null" || interestsTA.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, interests null");
			return false;
		}

		else {
			System.out.println(interestsTA.getText());			
			return true;
		}

	}
	
	//html tags as method
	public String h4(String info) {
		return "<h4>" + info + "</h4>" + "\n";
	}
	
	public String p(String info) {
		return "<p>" + info + "</p>" + "\n";
	}
	
	private String generateOthersHTML() {
		String title = "<h2><i>Others</i></h2>" + "\n";
		String skills = h4("Skills")
				+ p(skillsTA.getText());
		
		String interests = h4("Interests")
				+ p(interestsTA.getText());
		
		String othersHTML = "<div class=\"others\">" + "\n" + title + skills + interests + "</div>";
		return othersHTML;
	}
	
	
	
}
