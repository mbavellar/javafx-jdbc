package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController2 implements Initializable {
	
	@FXML
	private ComboBox<Person> comboBoxPersons;
	@FXML
	private Button btShowAll;
	
	private ObservableList<Person> obsListPersons;
	
	@FXML
	public void onBtShowAll() {
		comboBoxPersons.getItems().forEach(System.out::println);
	}
	
	@FXML
	public void onComboBoxPersonsAction() {
		Person person = comboBoxPersons.getSelectionModel().getSelectedItem();
		System.out.println(person);
		Alerts.showAlert("Combo Box", person.toString(), null, AlertType.INFORMATION);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Person> persons = new ArrayList<>() {{
			add(new Person(1, "Maria", "maria@gmail.com"));
			add(new Person(2, "Alex", "alex@gmail.com"));
			add(new Person(3, "Bob", "bob@gmail.com"));
		}};
		
		obsListPersons = FXCollections.observableArrayList(persons);
		comboBoxPersons.setItems(obsListPersons);
		
		Callback<ListView<Person>, ListCell<Person>> factory = listView -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		
		comboBoxPersons.setCellFactory(factory);
		comboBoxPersons.setButtonCell(factory.call(null));
	}
}
