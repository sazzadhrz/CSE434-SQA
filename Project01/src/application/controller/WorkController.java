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


	// Event Listener on Button[#back].onAction
	@FXML
	public void workBackBtnActionController(ActionEvent event) throws IOException {
		System.out.println("work back btn pressed");
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Education.fxml"));
		worklayout.getChildren().setAll(pane);
	}
	// Event Listener on Button[#cancel].onAction
	@FXML
	public void workCancelBtnActionController(ActionEvent event) throws IOException {
		System.out.println("Cancel btn pressed");

		Platform.exit();
		System.exit(0);
	}
	// Event Listener on Button[#next].onAction
	@FXML
	public void workNextBtnActionController(ActionEvent event) throws IOException {
		System.out.println("work next btn pressed");
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Others.fxml"));
		worklayout.getChildren().setAll(pane);
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
