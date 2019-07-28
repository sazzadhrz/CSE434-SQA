package application.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class WorkController {
	@FXML
	private VBox worklayout;
	@FXML
	private TextField name1;
	@FXML
	private TextField position1;
	@FXML
	private TextArea description1;
	@FXML
	private TextField name2;
	@FXML
	private TextField position2;
	@FXML
	private TextArea description2;
	@FXML
	private Label warningLabel;
	@FXML
	private Button back;
	@FXML
	private Button cancel;
	@FXML
	private Button next;
	
	public static String workHTML;

	// Event Listener on Button[#back].onAction
	@FXML
	public void workBackBtnActionController(ActionEvent event) throws IOException {
		System.out.println("work back btn pressed");
		EducationController.educationHtml = null;
		goToEducation();
	}

	// Event Listener on Button[#cancel].onAction
	@FXML
	public void workCancelBtnActionController(ActionEvent event) throws IOException {
		System.out.println("Cancel btn pressed");
		exit();
	}

	// Event Listener on Button[#next].onAction
	@FXML
	public void workNextBtnActionController(ActionEvent event) throws IOException {
		System.out.println("work next btn pressed");
		goToOthers();
	}

	public void exit() {
		Platform.exit();
		System.exit(0);
	}
	
	public void next() throws IOException {
		 if (fieldValidation()) {
			 System.out.println("validation done");
			 storeData();
			 goToOthers();
			 }
	}
	
	public void storeData() {
		//workHTML = generateWorkHTML();
		//Main.arraylist.add(workHTML);
	}
	
	public boolean fieldValidation() {
		return 
		fieldNullValidation() &&
		nameValidation() &&
		positionValidation();
	}

	public void goToOthers() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Others.fxml"));
		worklayout.getChildren().setAll(pane);
	}

	public void goToEducation() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Education.fxml"));
		worklayout.getChildren().setAll(pane);
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
		String regex = "^[\\p{L} .'-]+$";
		return name.matches(regex);
	}

	public boolean positionValidation() {
		if (isPositionValid(position1.getText()) && isPositionValid(position2.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("*Warning! Please Enter position name correctly");
			return false;
		}
	}

	public boolean isPositionValid(String positionName) {
		String regex = "^[a-zA-Z]+$";
		return positionName.matches(regex);
	}

	public boolean fieldNullValidation() {
		return
		name1FieldValidation() &&
		position1FieldValidation() &&
		description1FieldValidation() &&

		name2FieldValidation() &&
		position2FieldValidation() &&
		description2FieldValidation();
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

	public boolean position1FieldValidation() {
		if (position1.getText() == "null" || position1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(position1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}

	public boolean position2FieldValidation() {
		if (position2.getText() == "null" || position2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(position2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}

	public boolean description1FieldValidation() {
		if (description1.getText() == "null" || description1.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(description1.getText());
			System.out.println("True, name not null");
			return true;
		}

	}

	public boolean description2FieldValidation() {
		if (description2.getText() == "null" || description2.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(description2.getText());
			System.out.println("True, name not null");
			return true;
		}

	}
}
