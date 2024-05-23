package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Label counterLabel= new Label("0");

    @FXML
    private Button decrementButton;

    @FXML
    private Button incrementButton;

    int counter = 0;

    public void increment() {
        counter++;
        counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter--;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");
   }
}
