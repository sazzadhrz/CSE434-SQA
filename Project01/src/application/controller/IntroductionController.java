package application.controller;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
		exit();
	}

	public void exit() {
		Platform.exit();
		System.exit(0);
	}

	// scene change variables
	@FXML
	private StackPane introductionlayout;

	// Next button controller
	public void introductionNextBtnActionController(ActionEvent event) throws IOException {
		System.out.println("next btn pressed");
		next();
//		goToEducation();
	}
	
	public void next() throws IOException {
		 if (fieldValidation()) {
			 System.out.println("validation done");
			 addToMainList();
			 goToEducation();
			 }
	}

	public void goToEducation() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Education.fxml"));
		introductionlayout.getChildren().setAll(pane);
		introductionlayout.setMargin(pane, new Insets(50, 50, 50, 50));
	}

	private void addToMainList() {
		Main.arraylist.add(generateHeader());
		Main.arraylist.add(bodyOpen());

		Main.arraylist.add(generateIntroHtml());
		 System.out.println(Main.arraylist);

	}

	public boolean fieldValidation() {
		return fieldNullValidation() && nameValidation() && emailValidation() && phoneValidation();
	}

	// https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
	public boolean nameValidation() {
		if (isNameValid(nameTF.getText())) {
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

	public boolean emailValidation() {
		if (isEmailValid(emailTF.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("Invalid Email, please enter correct Email address");
			return false;
		}
	}

	// https://www.tutorialspoint.com/validate-email-address-in-java
	public boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public boolean phoneValidation() {
		if (isPhoneValid(phoneTF.getText())) {
			warningLabel.setText("");
			return true;
		} else {
			warningLabel.setText("Invalid Phone Number, please enter correct phone number");
			return false;
		}
	}

	public boolean isPhoneValid(String phone) {
//		String regex = "^[0-9+#* \\[\\w-\\]]+$";
		String regex = "^[0-9+# \\,-]*$";
		return phone.matches(regex) && phone.length() > 6;
	}

	public boolean fieldNullValidation() {
		if (nameFieldNullValidation() && 
				addressFieldNullValidation() && 
				emailFieldNullValidation()	&& 
				phoneFieldNullValidation()) {
			warningLabel.setText("");
			return true;
		} else
			return false;
	}
	
	public boolean isNull (String string) {
		return (string == "null" || string.trim().isEmpty());
	}

	// if null return false and raise warning on UI
	public boolean nameFieldNullValidation() {
		if (isNull(nameTF.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(nameTF.getText());
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean addressFieldNullValidation() {
		if (isNull(addressTF.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, address null");
			return false;
		}

		else {
			System.out.println(addressTF.getText());
			//System.out.println("True, address not null");
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean emailFieldNullValidation() {
		if (isNull(emailTF.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, email null");
			return false;
		}

		else {
			System.out.println(emailTF.getText());
			//System.out.println("True, email not null");
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean phoneFieldNullValidation() {
		if (isNull(phoneTF.getText())) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, phone null");
			return false;
		}

		else {
			System.out.println(phoneTF.getText());
			//System.out.println("True, phone not null");
			return true;
		}

	}

	// HTML tags as method
	public String h3(String info) {
		return "<h3>" + info + "</h3>" + "\n";
	}

	public String h1(String info) {
		return "<h1>" + info + "</h1>" + "\n";
	}

	private String generateIntroHtml() {
		return "<div class=\"introduction\">" + "\n" + h1(nameTF.getText()) + h3(addressTF.getText())
				+ h3(emailTF.getText()) + h3(phoneTF.getText()) + "</div>";
	}

	private String generateHeader() {
		String head = "<head>" + "\n" + "<title>Resume of " + nameTF.getText() + "</title>" + "\n" + "</head>";
		return head;
	}

	private String bodyOpen() {
		return "<body>";
	}

}
