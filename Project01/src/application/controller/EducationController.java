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
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Work.fxml"));
		educationlayout.getChildren().setAll(pane);
		
	}
	
	public void educationBackBtnActionController() throws IOException {
		System.out.println("edu back btn pressed");
		StackPane pane = FXMLLoader.load(getClass().getResource("../view/Introduction.fxml"));
		educationlayout.getChildren().setAll(pane);
		educationlayout.setMargin(pane, new Insets(-50,-50,-50,-50));
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
	
	public boolean degre2FieldValidation() {
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
	
	

}
