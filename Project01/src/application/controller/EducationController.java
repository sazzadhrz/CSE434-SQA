package application.controller;

import java.io.IOException;

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
	
	
	
	
	public void educationCancelBtnActionController() {
		System.out.println("Cancel btn pressed");

		Platform.exit();
		System.exit(0);
	}
	
	public void educationNextBtnActionController() throws IOException {
		System.out.println("edu next btn pressed");
		goToWork();
	}
	
	public void educationBackBtnActionController() throws IOException {
		System.out.println("edu back btn pressed");
		
	}
	
	public void goToIntroduction() throws IOException {
		StackPane pane = FXMLLoader.load(getClass().getResource("../view/Introduction.fxml"));
		educationlayout.getChildren().setAll(pane);
		educationlayout.setMargin(pane, new Insets(-50,-50,-50,-50));
	}
	
	public void goToWork() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Work.fxml"));
		educationlayout.getChildren().setAll(pane);
	}
	
	public void fieldValidation() {
		fieldNullValidation();
		nameValidation();
	}
	
	public boolean nameValidation() {
		if(isNameValid(name1.getText()) && isNameValid(name2.getText())) {
			warningLabel.setText("");
			return true;
		}
		else {
			warningLabel.setText("*Warning! Please Enter name correctly");
			return false;
		}
	}	
	
	public boolean isNameValid(String name) {
		String regex = "^[\\p{L} .'-]+$";
		return name.matches(regex);
	}
	
	
	public void fieldNullValidation() {
		name1FieldValidation();
		degree1FieldValidation();
		year1FieldValidation();
		cgpa1FieldValidation();
		
		name2FieldValidation();
		degree2FieldValidation();
		year2FieldValidation();
		cgpa2FieldValidation();
	}
	
	
	public boolean name1FieldValidation() {
		if (name1.getText() == "null" || name1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(name1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean name2FieldValidation() {
		if (name2.getText() == "null" || name2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(name2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean degree1FieldValidation() {
		if (degree1.getText() == "null" || degree1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(degree1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean degree2FieldValidation() {
		if (degree2.getText() == "null" || degree2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(degree2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean year1FieldValidation() {
		if (year1.getText() == "null" || year1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(year1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean year2FieldValidation() {
		if (year2.getText() == "null" || year2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(year2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean cgpa1FieldValidation() {
		if (cgpa1.getText() == "null" || cgpa1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(cgpa1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	public boolean cgpa2FieldValidation() {
		if (cgpa2.getText() == "null" || cgpa2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(cgpa2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
	
	

}
