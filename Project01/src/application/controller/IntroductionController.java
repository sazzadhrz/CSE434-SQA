package application.controller;
import application.view.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IntroductionController {
	@FXML Button button;
	@FXML Label label;
	@FXML TextField textField;
	
	public void buttonActionController() {
		String text = textField.getText();
		label.setText(text);
	}
}
