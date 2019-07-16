package application.controller;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IntroductionController {
	@FXML
	Button introductionNextBtn;
	@FXML
	Button introductionCancelBtn;
	@FXML
	TextField nameTF;
	@FXML
	TextField addressTF;
	@FXML
	TextField emailTF;
	@FXML
	TextField phoneTF;
	@FXML
	Label warningLabel;

	// Cancel button controller
	public void introductionCancelBtnActionController() {
		System.out.println("Cancel btn pressed");

		Platform.exit();
		System.exit(0);
	}

	// Next button controller
	public void introductionNextBtnActionController() {
		System.out.println("next btn pressed");

		Main.arraylist.add(generateHeader());
		Main.arraylist.add(bodyOpen());
		Main.arraylist.add(generateIntroHtml());
		// System.out.println(Main.arraylist);

		nameFieldValidation();
	}
	
	//if null return false and raise warning on UI
	public boolean nameFieldValidation() {
		if (nameTF.getText() == "null" || nameTF.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False");
			return false;
		}

		else {
			System.out.println(nameTF.getText());
			System.out.println("True; not null");
			return true;
		}

	}
	
	//if null return false and raise warning on UI
		public boolean addressFieldValidation() {
			if (addressTF.getText() == "null" || addressTF.getText().trim().isEmpty()) {
				warningLabel.setText("*Warning! All of the fields must be filled up");
				System.out.println("False");
				return false;
			}

			else {
				System.out.println(nameTF.getText());
				System.out.println("True; not null");
				return true;
			}

		}
		
		

	// HTML tags as method
	private String h5(String info) {
		return "<h5>" + info + "</h5>" + "\n";
	}

	// HTML tags as method
	private String h2(String info) {
		return "<h2>" + info + "</h2>" + "\n";
	}

	private String generateIntroHtml() {
		return "<div class=\"introduction\">" + "\n" + h2(nameTF.getText()) + h5(addressTF.getText())
				+ h5(emailTF.getText()) + h5(phoneTF.getText()) + "</div>";
	}

	private String generateHeader() {
		String head = "<head>" + "\n" + "<title>Resume of " + nameTF.getText() + "</title>" + "\n" + "</head>";
		return head;
	}

	private String bodyOpen() {
		return "<body>";
	}

}
