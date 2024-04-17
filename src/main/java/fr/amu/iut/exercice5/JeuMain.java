package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Timer;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    // ajout d'un timer
    private long startTimer = System.currentTimeMillis();
    private long endTimer = startTimer + 20 * 1000;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();
        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        Obstacle obstacle = new Obstacle();
        // on configure un timer
        Timer tm = new Timer();
        // on positionne le fantôme à l'extrémité du jeu
        fantome.setLayoutX(640-20);
        fantome.setLayoutY(480-20);
        // on configure le rectangle
        obstacle.setX(60);
        obstacle.setY(60);
        obstacle.setWidth(200);
        obstacle.setHeight(100);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacle);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacle);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle o) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (System.currentTimeMillis() > endTimer){
                System.out.println("Fin du jeu");
                System.exit(0);
            }
            // récupération position j1 avant mouvement
            double j1X = j1.getLayoutX();
            double j1Y = j1.getLayoutY();
            // récupération position j2 avant mouvement
            double j2X = j2.getLayoutX();
            double j2Y = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
            }
            if (j1.estEnCollision(j2)){
                System.out.println("Collision....");
                System.exit(0);
            }
            if (j1.estEnCollisionAvecObstacle(o)){
                j1.relocate(j1X, j1Y);
                System.out.println("Collision avec un obstacle....");
            }
            if (j2.estEnCollisionAvecObstacle(o)){
                j2.relocate(j2X, j2Y);
                System.out.println("Collision avec un obstacle....");
            }
        });
    }


}
