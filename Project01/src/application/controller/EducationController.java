package application.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

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
	
	public void educationCancelBtnActionController() {
		System.out.println("Cancel btn pressed");

		Platform.exit();
		System.exit(0);
	}

}
