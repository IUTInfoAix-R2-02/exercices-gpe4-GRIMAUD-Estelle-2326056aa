package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private IntegerProperty nbFois;

    private Label texteDuHaut;
    private StringProperty message;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;

    private Pane panneau;
    private StringProperty couleurPanneau;
    private HBox boutons;

    private Label texteDuBas;

    public Palette(){
        nbFois = new SimpleIntegerProperty();
        message = new SimpleStringProperty("");
        couleurPanneau = new SimpleStringProperty("#000000");
    }

    private void createBindings() {

        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(true);
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));

        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic)
                .then("Aucun clic détecté")
                .otherwise(Bindings.format("Total des clics : %d", nbFois)));

        panneau.styleProperty().bind(Bindings.createStringBinding(
                () -> String.format("-fx-background-color: %s;", couleurPanneau.get()),
                couleurPanneau
        ));

        texteDuBas.textProperty().bind(message);

        texteDuBas.styleProperty().bind(Bindings.createStringBinding(
                () -> String.format("-fx-text-fill: %s;", couleurPanneau.get()),
                couleurPanneau
        ));

        couleurPanneau.addListener((obs, oldVal, newVal) -> {
            switch (newVal) {
                case "green":
                    message.set("Le Vert est une jolie couleur !");
                    break;
                case "red":
                    message.set("Le Rouge est une jolie couleur !");
                    break;
                case "blue":
                    message.set("Le Bleu est une jolie couleur !");
                    break;
                default:
                    message.set("");
                    break;
            }
        });
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        vert.setOnAction(event -> {
            this.nbVert += 1;
            nbFois.set(nbFois.get() + 1);
            couleurPanneau.set("green");
            //this.panneau.setStyle("-fx-background-color: green");
        });
        rouge = new Button("Rouge");
        rouge.setOnAction(event -> {
            this.nbRouge += 1;
            nbFois.set(nbFois.get() + 1);
            couleurPanneau.set("red");
            //this.panneau.setStyle("-fx-background-color: red");
        });
        bleu = new Button("Bleu");
        bleu.setOnAction(event -> {
            this.nbBleu += 1;
            nbFois.set(nbFois.get() + 1);
            couleurPanneau.set("blue");
            //this.panneau.setStyle("-fx-background-color: blue");
        });

        createBindings();

        /* VOTRE CODE ICI */

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

