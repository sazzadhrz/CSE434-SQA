package application.controller;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class IntroductionController {
	@FXML Button introductionNextBtn;
	@FXML TextField nameTF;
	@FXML TextField addressTF;
	@FXML TextField emailTF;
	@FXML TextField phoneTF;
	
	public void introductionNextBtnActionController() {
		System.out.println("next btn pressed");
//		Main.arraylist.add(generateIntroHtml());
		System.out.println(generateIntroHtml());

	}
	
	private String h5(String info) {
		return "<h5>" + info + "</h5>" + "\n";
	}
	
	private String h2(String info) {
		return "<h2>" + info + "</h2>" + "\n";
	}
	
	@SuppressWarnings("unused")
	private String generateIntroHtml() {
		return 
		h2(nameTF.getText()) +
		h5(addressTF.getText()) +
		h5(emailTF.getText()) +
		h5(phoneTF.getText());
	}
	
	
}
