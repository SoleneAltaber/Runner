import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class GameScene extends Scene {

    // definition des variables

    private Camera camera;
    private StaticThings left = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private StaticThings right = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private Hero perso = new Hero("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros1.png", 300, 0);
    private Foe mechant = new Foe("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\foe.png", 1000, 10);
    private StaticThings fin = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\fin.png", 50, 1000);

    private double v;
    private double v1;
    AnimationTimer timer= new AnimationTimer() {
        public void handle(long time) {
            perso.update(time);
            camera.update(time);
            mechant.update(time);
            render();
        }
    };

    // constructeur

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        camera = new Camera(1205,0,perso);
        timer.start();
        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        group.getChildren().add(perso.getImage());
        group.getChildren().add(mechant.getImage());
        group.getChildren().add(fin.getImage());


        this.setOnKeyPressed(event->{
            if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("Jump");
                    if (perso.y<=10.5){
                            perso.jump();
                    }
            }
        });
        render();

    }
    //fonction game over
    public void gameOver(){
        if (mechant.getX()<=perso.getX()+10){
            fin.getImage().setX(100);}// on remet l'image cachée a la bonne place
    }

 // fonction render
    public void render(){
        double xCam=camera.getX();
        double offsetLeft=xCam%left.getX();
        System.out.println("Heros en y: "+perso.getY());
        System.out.println("Heros en x: "+perso.getX());
        System.out.println("mechant en y: "+mechant.getY());
        System.out.println("mechant en x: "+mechant.getX());
        System.out.println("vitesse : "+perso.getyVitess());

        if (perso.getyVitess()>0.2) {       //animation hero monte et descend
            perso.monte=true;
            perso.descend=false;}
        if (perso.getyVitess()<-0.4)
            {perso.descend=true;
            perso.monte=false;}
        if (perso.y<11)
            {perso.descend=false;
            perso.monte=false;}


        //game over

        if (mechant.getX()<=perso.getX()+10 && perso.getY()<=mechant.getY()+1 ){        //si on perd on cache tout et on met l'ecran de fin
            fin.getImage().setX(100);
            perso.getImage().setX(-1000);
            perso.getImage().setY(0);
            mechant.getImage().setX(-2000);
            mechant.getImage().setY(20);}
        else{fin.getImage().setX(-1000);    // sinon on joue
            perso.getImage().setY(400-150-perso.getY());
            perso.getImage().setX(perso.getX()-camera.getX());
            mechant.getImage().setY(400-150-mechant.getY());
            mechant.getImage().setX(mechant.getX()-camera.getX());
            if (mechant.getX()<perso.getX()-50){    //réapparaition du monstre à droite
                mechant.x= perso.getX()+1000;}
        } // on cache l'image


        left.getImage().setX(-offsetLeft);
        right.getImage().setX(800-offsetLeft);



    }

}