import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class GameScene extends Scene {

    // definition des variables

    private Camera camera;
    private final StaticThings left = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private final StaticThings right = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private Hero perso = new Hero("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros1.png", 300, 0);
    private final Foe mechant = new Foe("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\foe.png", 1000, 10);
    private final StaticThings fin = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\fin.png", 400, 400);
    private final StaticThings debut = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\debut1.png",400,400);
    private boolean jumpok=true;  // on allow le jump
    private double v;
    private double v1;
    public boolean debJeu=true;
    AnimationTimer timer= new AnimationTimer() {
        public void handle(long time) {
                perso.update(time);
                camera.update(time);
                mechant.update(time);
                render();

        }
    };

    //_________________________________________________________________CONSTRUCTEUR__________________________________________________________________________________


    public GameScene(Group group, double v, double v1) {

        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        camera = new Camera(300, 0, perso);



            group.getChildren().add(debut.getImage());
            group.getChildren().add(left.getImage());
            group.getChildren().add(right.getImage());
            group.getChildren().add(perso.getImage());
            group.getChildren().add(mechant.getImage());
            group.getChildren().add(fin.getImage());
            timer.start();
            render();
        }





//_____________________________________________________________________METHODE__________________________________________________________________________________



   // fonction sauter
   public void sauter(){
       if (perso.getyVitess()>0.2) {       //animation hero monte et descend
           perso.monte=true;
           perso.descend=false;}
       if (perso.getyVitess()<-0.4) {
           perso.descend=true;
           perso.monte=false;}
       if (perso.y<11) {
           perso.descend=false;
           perso.monte=false;}
       this.setOnKeyPressed(event->{   // on saute quand on presse espace
           if (event.getCode() == KeyCode.SPACE) {
               if (perso.getY()<=10.5 && jumpok==true){
                   perso.jump();
               }
           }
       });

   }

 // fonction render
    public void render(){
        mechant.debJeu=debJeu;
        perso.debJeu=debJeu;
        double xCam=camera.getX();
        double offsetLeft=xCam%left.getX();
        System.out.println("left en y: "+left.getY());
        System.out.println("left en x: "+left.getX());
        System.out.println("right en y: "+right.getY());
        System.out.println("right en x: "+right.getX());
        System.out.println("cam : "+camera.getX());
        System.out.println("cam : "+camera.getY());
        sauter();
        //game over
    if(debJeu==false) {

        if (mechant.getX() <= perso.getX() + 50 && perso.getY() <= mechant.getY() + 10) {        //si on perd? on cache tout et on met l'ecran de fin  et on empeche de sauter sinon le jeu reprend
            debut.getImage().setX(-1000);
            fin.getImage().setX(125);
            perso.getImage().setX(-1000);
            perso.getImage().setY(20);
            mechant.getImage().setX(-2000);
            mechant.getImage().setY(100);
            jumpok = false;
        }
        else {
            debut.getImage().setX(-1000);
            fin.getImage().setX(-1000);    // sinon on joue
            perso.getImage().setY(400 - 150 - perso.getY());
            perso.getImage().setX(perso.getX() - camera.getX());
            mechant.getImage().setY(400 - 150 - mechant.getY());
            mechant.getImage().setX(mechant.getX() - camera.getX());
            if (mechant.getX() < perso.getX() - 50) {    //réapparaition du monstre à droite
                mechant.x = perso.getX() + 1000;
                mechant.Vmechant=mechant.Vmechant+0.25; // on fait accelerer le monstre
            }
        }
        left.getImage().setX(-offsetLeft);
        right.getImage().setX(800-offsetLeft);
    }
    if (debJeu==true){
        fin.getImage().setX(125);
        debut.getImage().setX(100);
        this.setOnKeyPressed(event->{
            if (event.getCode() == KeyCode.ENTER) {
                debJeu=false;
            }
        });
    }
    }
}

