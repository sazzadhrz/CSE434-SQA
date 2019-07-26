package application.controller;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

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
	public void introductionNextBtnActionController(ActionEvent event) throws IOException {
		System.out.println("next btn pressed");

		Main.arraylist.add(generateHeader());
		Main.arraylist.add(bodyOpen());
		
		Main.arraylist.add(generateIntroHtml());
		// System.out.println(Main.arraylist);

		fieldValidation();
//		openRegister();
//		loadScene(null);
		
		BorderPane pane = FXMLLoader.load(getClass().getResource("../view/Test.fxml"));
		mainlayout.getChildren().setAll(pane);
		
	}
	
	private Stage stage;
	@FXML
	private StackPane mainlayout;
	
	@FXML
	private void loadScene(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("../application.view/Test.fxml"));
		mainlayout.getChildren().setAll(pane);
		
	}
	
	@FXML
    private void openRegister() throws IOException{
        stage = (Stage) introductionNextBtn.getScene().getWindow();
        //BorderPane root;
        FXMLLoader loader = new FXMLLoader();
        mainlayout = loader.load();
		loader.setLocation(IntroductionController.class.getClassLoader().getResource("/view/Test.fxml")); //problem is in this line
		
		
        //root = (BorderPane) FXMLLoader.load(getClass().getClassLoader().getResource("Test.fxml"));
        Scene scene = new Scene(mainlayout);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        System.out.println("Test.fxml opened");
    }
	
//	 @FXML
//	    private void openRegister() throws IOException{
//	        stage = (Stage) introductionNextBtn.getScene().getWindow();
//	        BorderPane root;
//	        root = (BorderPane) FXMLLoader.load(getClass().getClassLoader().getResource("view/Test.fxml"));
//	        Scene scene = new Scene(root);
//	        stage.setScene(scene);
//	        System.out.println("Register.fxml opened");
//	    }

	
	public void onBtnClick(ActionEvent event) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("application/view/Education.fxml"));
	        Stage stage = (Stage) introductionNextBtn.getScene().getWindow();
	        Scene scene = new Scene(loader.load());
	        stage.setScene(scene);
	    }catch (IOException io){
	        io.printStackTrace();
	    }

	}
	
	public void fieldValidation() {
		nameFieldValidation();
		addressFieldValidation();
		emailFieldValidation();
		phoneFieldValidation();
	}

	// if null return false and raise warning on UI
	public boolean nameFieldValidation() {
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
	public boolean addressFieldValidation() {
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
	public boolean emailFieldValidation() {
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
	public boolean phoneFieldValidation() {
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
