package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	
	@FXML
	private TextField txtFieldNum1;
	@FXML
	private TextField txtFieldNum2;
	@FXML
	private Label labelResult;
	@FXML
	private Button btSum;
	
	@FXML
	public void onBtSumAction() {
		Locale.setDefault(Locale.US);
		try {
		    double num1 = Double.parseDouble(txtFieldNum1.getText());
		    double num2 = Double.parseDouble(txtFieldNum2.getText());
		    labelResult.setText(String.format("%.2f", num1 + num2));
		}
		catch (NumberFormatException e) {
		    Alerts.showAlert("Error", null, "Parse error. Not a number!", AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtFieldNum1);
		Constraints.setTextFieldDouble(txtFieldNum2);
		Constraints.setTextFieldMaxLenght(txtFieldNum1, 12);
		Constraints.setTextFieldMaxLenght(txtFieldNum2, 12);
	}
}
