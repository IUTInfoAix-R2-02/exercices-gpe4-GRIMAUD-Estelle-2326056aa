package fr.amu.iut.exercice6;

import com.example.partie2.BonjourFenetre;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    private int nbVies;
    private Label label;
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création d'un conteneur VBox avec ses éléments centrés
        VBox vbox = new VBox();
        vbox.setAlignment( Pos.CENTER );

        // Image pendu
        ImageView pendu7 = new ImageView("exercice6/pendu7.png");
        Label pendu = new Label();
        pendu.setGraphic(pendu7);
        vbox.getChildren().add(pendu7);

        // Décompte vies
        this.nbVies = 7;
        this.label = new Label();
        label.setText("Nombre de vies : " + nbVies);
        vbox.getChildren().add(label);

        // Alphabet
        GridPane alphabet = new GridPane();
        alphabet.setAlignment(Pos.CENTER);
        // Boutons alphabet
        Button a = new Button("a");
        Button e = new Button("e");
        Button i = new Button("i");
        Button o = new Button("o");
        Button u = new Button("u");
        Button y = new Button("y");

        Button b = new Button("b");
        Button c = new Button("c");
        Button d = new Button("d");
        Button f = new Button("f");
        Button g = new Button("g");
        Button h = new Button("h");
        Button j = new Button("j");
        Button k = new Button("k");
        Button l = new Button("l");
        Button m = new Button("m");

        Button n = new Button("n");
        Button p = new Button("p");
        Button q = new Button("q");
        Button r = new Button("r");
        Button s = new Button("s");
        Button t = new Button("t");
        Button v = new Button("v");
        Button w = new Button("w");
        Button x = new Button("x");
        Button z = new Button("z");

        // Ajout boutons à alphabet
        // première ligne
        alphabet.add(a, 2,0);
        alphabet.add(e, 3,0);
        alphabet.add(i, 4,0);
        alphabet.add(o, 5,0);
        alphabet.add(u, 6,0);
        alphabet.add(y, 7,0);
        // deuxième ligne
        alphabet.add(b, 0,1);
        alphabet.add(c, 1,1);
        alphabet.add(d, 2,1);
        alphabet.add(f, 3,1);
        alphabet.add(g, 4,1);
        alphabet.add(h, 5,1);
        alphabet.add(j, 6,1);
        alphabet.add(k, 7,1);
        alphabet.add(l, 8,1);
        alphabet.add(m, 9,1);
        // troisième ligne
        alphabet.add(n, 0,2);
        alphabet.add(p, 1,2);
        alphabet.add(q, 2,2);
        alphabet.add(r, 3,2);
        alphabet.add(s, 4,2);
        alphabet.add(t, 5,2);
        alphabet.add(v, 6,2);
        alphabet.add(w, 7,2);
        alphabet.add(x, 8,2);
        alphabet.add(z, 9,2);

        vbox.getChildren().add(alphabet);

        // bouton rejouer
        Button rejouer = new Button("Rejouer");
        vbox.getChildren().add(rejouer);

        // Création de la scene
        Scene scene = new Scene(vbox);

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
