package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class SuccessController {
	@FXML
	private Label msg;
	@FXML
	private Button finishBtn;

	// Event Listener on Button[#finishBtn].onAction
	@FXML
	public void endProgram(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
}
