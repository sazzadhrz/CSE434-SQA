package application.controller;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class EducationController {
	@FXML
	private TextField name1;
	@FXML
	private TextField degree1;
	@FXML
	private TextField year1;
	@FXML
	private TextField cgpa1;
	@FXML
	private TextField name2;
	@FXML
	private TextField degree2;
	@FXML
	private TextField year2;
	@FXML
	private TextField cgpa2;
	@FXML
	private Label warningLabel;
	@FXML
	private Button back;
	@FXML
	private Button cancel;
	@FXML
	private Button next;

	@FXML
	private VBox educationlayout;

	public static String educationHtml;

	public void educationCancelBtnActionController() {
		System.out.println("Cancel btn pressed");
		exit();
	}

	public void educationNextBtnActionController() throws IOException {
		System.out.println("edu next btn pressed");
		next();
	}

	public void educationBackBtnActionController() throws IOException {
		System.out.println("edu back btn pressed");
		Main.arraylist.clear(); // clears the main list
		goToIntroduction();
	}

	public void next() throws IOException {
		if (fieldValidation()) {
			System.out.println("validation done");
			storeData();
			goToWork();
		}
	}

	public void storeData() {
		educationHtml = generateEducationHTML();
		// Main.arraylist.add(educationHtml);
	}

	public void exit() {
		Platform.exit();
		System.exit(0);
	}

	public void goToIntroduction() throws IOException {
		StackPane pane = FXMLLoader.load(getClass().getResource("../view/Introduction.fxml"));
		educationlayout.getChildren().setAll(pane);
		educationlayout.setMargin(pane, new Insets(-50, -50, -50, -50));
	}

	public void goToWork() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Work.fxml"));
		educationlayout.getChildren().setAll(pane);
	}

	public boolean fieldValidation() {
		return fieldNullValidation() && nameValidation() && degreeValidation() && yearValidation() && cgpaValidation();
	}

	public boolean nameValidation() {
		if (isNameValid(name1.getText()) && isNameValid(name2.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("*Warning! Please Enter name correctly");
			return false;
		}
	}

	public boolean isNameValid(String name) {
		// String regex = "^[\\p{L} .'-]+$";
		String regex = "^[a-zA-Z ]+$";
		return name.matches(regex);
	}

	public boolean degreeValidation() {
		if (isDegreeValid(degree1.getText()) && isDegreeValid(degree2.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("*Warning! Please Enter degree name correctly");
			return false;
		}
	}

	public boolean isDegreeValid(String DegreeName) {
		String regex = "^[a-zA-Z ]+$";
		return DegreeName.matches(regex);
	}

	public boolean yearValidation() {
		if (isYearValid(year1.getText()) && isYearValid(year2.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("*Warning! Please Enter year correctly");
			return false;
		}
	}

	public boolean isYearValid(String year) {
		String regex = "^[a-zA-Z0-9 _.-]*$";
		return year.matches(regex);
	}

	public boolean cgpaValidation() {
		if (isCgpaValid(cgpa1.getText()) && isCgpaValid(cgpa2.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("*Warning! Please Enter cgpa correctly");
			return false;
		}

	}

	public boolean isCgpaValid(String cgpa) {
		String regex = "^[0-5][.][0-9][0-9]$";

		if (cgpa.matches(regex)) {
			if (Float.parseFloat(cgpa) <= 5)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean fieldNullValidation() {
		return name1FieldValidation() && degree1FieldValidation() && year1FieldValidation() && cgpa1FieldValidation() &&

				name2FieldValidation() && degree2FieldValidation() && year2FieldValidation() && cgpa2FieldValidation();
	}

	public boolean isNull(String string) {
		return (string == "null" || string.trim().isEmpty());
	}

	public boolean name1FieldValidation() {
		if (isNull(name1.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name1 null");
			return false;
		}

		else {
			System.out.println(name1.getText());
			return true;
		}

	}

	public boolean name2FieldValidation() {
		if (isNull(name2.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name2 null");
			return false;
		}

		else {
			System.out.println(name2.getText());
			return true;
		}

	}

	public boolean degree1FieldValidation() {
		if (isNull(degree1.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, degree1 null");
			return false;
		}

		else {
			System.out.println(degree1.getText());
			return true;
		}

	}

	public boolean degree2FieldValidation() {
		if (isNull(degree2.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, degree2 null");
			return false;
		}

		else {
			System.out.println(degree2.getText());
			return true;
		}

	}

	public boolean year1FieldValidation() {
		if (isNull(year1.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, year1 null");
			return false;
		}

		else {
			System.out.println(year1.getText());
			return true;
		}

	}

	public boolean year2FieldValidation() {
		if (isNull(year2.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, year2 null");
			return false;
		}

		else {
			System.out.println(year2.getText());
			return true;
		}

	}

	public boolean cgpa1FieldValidation() {
		if (isNull(cgpa1.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, cgpa1 null");
			return false;
		}

		else {
			System.out.println(cgpa1.getText());
			return true;
		}

	}

	public boolean cgpa2FieldValidation() {
		if (isNull(cgpa2.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, cgpa2 null");
			return false;
		}

		else {
			System.out.println(cgpa2.getText());
			return true;
		}

	}

	// HTML tags as method
	public String h5(String info) {
		return "<h5>" + info + "</h5>" + "\n";
	}

	public String h3(String info) {
		return "<h3>" + info + "</h3>" + "\n";
	}

	public String h4(String info) {
		return "<h4>" + info + "</h4>" + "\n";
	}

	private String generateEducationHTML() {
		String title = "<h2><i>Educational Background</i></h2>" + "\n";
		String edu1 = h3(name1.getText()) + h4(degree1.getText()) + h5(year1.getText()) + h5(cgpa1.getText());

		String edu2 = h3(name2.getText()) + h4(degree2.getText()) + h5(year2.getText()) + h5(cgpa2.getText());

		String educationHTML = "<div class=\"education\">" + "\n" + title + edu1 + edu2 + "</div>";
		return educationHTML;
	}

}
