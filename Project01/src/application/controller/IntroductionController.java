package application.controller;
import application.view.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IntroductionController {
	@FXML Button introductionNextBtn;
	
	public void introductionNextBtnActionController() {
		System.out.println("next btn pressed");
	}
}
