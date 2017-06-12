package calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class IBANController {

	
	@FXML
	private TextField input;
	
	@FXML
	private Text pruefziffer;
	
	@FXML
	private Text laender;
	
	@FXML
	private Text blz;
	
	@FXML
	private Text konto;
	
	@FXML
	private Text output;
	
	private String iban;
	
	private IBANModel model = new IBANModel();
	
	@FXML
	private void processInput(){
		iban = input.getText();
		iban=iban.replace(" ", "");
		
		if (iban.length()!=22){
			output.setText("Ihre IBAN hat nicht die gew�nschte L�nge");
		} else if (!(iban.substring(2).matches("[0-9]+"))) {
			output.setText("Ihre IBAN enth�lt Zeichen, die nicht in einer Kontonummer vorhanden sein sollten");	
		}
		else if (!(iban.substring(0,2).matches("[A-Z]+"))){
			output.setText("Ihre IBAN enth�lt keine g�ltige L�nderangabe");
		} 	else {
			iban.substring(0, 2).toUpperCase();
			model.setIban(iban);
			if (model.istCorrect()){
				output.setText("Ihre IBAN ist korrekt");
				laender.setText(iban.substring(0,2));
				pruefziffer.setText(iban.substring(2,4));
				blz.setText(iban.substring(4,13));
				konto.setText(iban.substring(13));
			}
			else {
				output.setText("Das war leider eine falsche IBAN");
			}
		}
	}
	
	@FXML
	private void processTextArea(KeyEvent e){
		if (e.getCode().toString().equals("ENTER")){
			processInput();
		}
	}
	
	@FXML
	private void exit(){
		System.exit(0);
	}
}
