package fr.amu.iut.exercice4;

import com.example.partie2.ButtonClickHandler;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;
    private HBox haut;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.root = new BorderPane();
        this.bas = new HBox();
        this.haut = new HBox();

        haut.setAlignment( Pos.CENTER );
        haut.setPadding(new Insets(10));

        bas.setAlignment( Pos.CENTER );
        bas.setSpacing(10);
        bas.setPadding(new Insets(10));

        // Ajout de boutons avec du texte
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        this.bas.getChildren().addAll( vert, rouge, bleu );

        // Ajout événements lors des clics boutons

        this.panneau = new Pane();

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED,  actionEvent -> {
            this.nbVert += 1;
            label.setText("Vert choisi " + nbVert + " fois");
            this.panneau.setStyle("-fx-background-color: green");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED,  actionEvent -> {
            this.nbRouge += 1;
            label.setText("Rouge choisi " + nbRouge + " fois");
            this.panneau.setStyle("-fx-background-color: red");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED,  actionEvent -> {
            this.nbBleu += 1;
            label.setText("Bleu choisi " + nbBleu + " fois");
            this.panneau.setStyle("-fx-background-color: blue");
        });

        // Ajout du label
        this.label = new Label();
        this.haut.getChildren().add(label);

        // Ajout dans un border pane
        root.setTop(haut);
        root.setBottom(bas);
        root.setCenter(panneau);

        // Création de la scene
        Scene scene = new Scene( root );

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}

