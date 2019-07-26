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
		Platform.exit();
		System.exit(0);
	}
	
	//scene change variables
	//private Stage stage;
	@FXML
	private StackPane introductionlayout;

	// Next button controller
	public void introductionNextBtnActionController(ActionEvent event) throws IOException {
		System.out.println("next btn pressed");
		if (fieldValidation()) {
			System.out.println("validation done");
			pushDataToNext();
			goToEducation();
		}
	}
	
	public void goToEducation() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Education.fxml"));
		introductionlayout.getChildren().setAll(pane);
		introductionlayout.setMargin(pane, new Insets(50,50,50,50));
	}
	
	private void pushDataToNext() {
		Main.arraylist.add(generateHeader());
		Main.arraylist.add(bodyOpen());
		
		Main.arraylist.add(generateIntroHtml());
		// System.out.println(Main.arraylist);

	}

	
	public boolean fieldValidation() {
		return fieldNullValidation() &&
		nameValidation() &&
		emailValidation() &&
		phoneValidation();
	}
	
	
	// https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
	public boolean nameValidation() {
		String regx = "^[\\p{L} .'-]+$";
		if(nameTF.getText().matches(regx)) {
			warningLabel.setText("");
			return true;
		}
		else {
			warningLabel.setText("*Warning! Please Enter name correctly");
			return false;
		}
	}	
	
	// https://www.tutorialspoint.com/validate-email-address-in-java
	public boolean emailValidation() {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(emailTF.getText().matches(regex)) {
	    	  warningLabel.setText("");
	    	  return true;
	      }
	      else {
	    	  warningLabel.setText("Invalid Email, please enter correct Email address");
	    	  return false;
	      }
	}
	
	
	public boolean phoneValidation() {
	      String regex = "^[0-9+#*\\[\\]]+$";
	      if(phoneTF.getText().matches(regex)) {
	    	  warningLabel.setText("");
	    	  return true;
	      }
	      else {
	    	  warningLabel.setText("Invalid Phone Number, please enter correct phone number");
	    	  return false;
	      }
	   }
	
	
	public boolean fieldNullValidation() {
		if(nameFieldNullValidation() && addressFieldNullValidation() && emailFieldNullValidation() && phoneFieldNullValidation()) {
			warningLabel.setText("");
			return true;
		}
		else
			return false;
	}

	// if null return false and raise warning on UI
	public boolean nameFieldNullValidation() {
		if (nameTF.getText() == "null" || nameTF.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, name null");
			return false;
		}

		else {
			System.out.println(nameTF.getText());
			System.out.println("True, name not null");
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean addressFieldNullValidation() {
		if (addressTF.getText() == "null" || addressTF.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, address null");
			return false;
		}

		else {
			System.out.println(addressTF.getText());
			System.out.println("True, address not null");
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean emailFieldNullValidation() {
		if (emailTF.getText() == "null" || emailTF.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, email null");
			return false;
		}

		else {
			System.out.println(emailTF.getText());
			System.out.println("True, email not null");
			return true;
		}

	}

	// if null return false and raise warning on UI
	public boolean phoneFieldNullValidation() {
		if (phoneTF.getText() == "null" || phoneTF.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, phone null");
			return false;
		}

		else {
			System.out.println(phoneTF.getText());
			System.out.println("True, phone not null");
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
