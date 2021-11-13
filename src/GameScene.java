import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class GameScene extends Scene {

    public GameScene(Group group, double v, double v1) {
        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        camera = new Camera(1205,0,perso);
        timer.start();
        group.getChildren().add(left.getImage());
        group.getChildren().add(right.getImage());
        group.getChildren().add(perso.getImage());

        this.setOnKeyPressed(event->{
            if (event.getCode() == KeyCode.SPACE) {
                    System.out.println("Jump");
                    if (perso.jumpnb<2){
                    perso.jump();}
                    else {perso.jumpnb=0;}

            }
        });

        render();
        }


    private Camera camera;
    private StaticThings left = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private StaticThings right = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private Hero perso = new Hero("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros.png", 300, 0);
    private Foe mechant = new Foe("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\foe.png", 500, 10);
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

    public void render(){
        double xCam=camera.getX();
        double offsetLeft=xCam%left.getX();
        System.out.println("y= : "+perso.jumpnb);
        System.out.println("Heros en y: "+perso.getY());
        System.out.println("Heros en x: "+perso.getX());
        System.out.println("mechant en y: "+mechant.getY());
        System.out.println("mechant en x: "+mechant.getX());
        System.out.println("vitesse : "+perso.getyVitess());
        left.getImage().setX(-offsetLeft);
        right.getImage().setX(800-offsetLeft);
        perso.getImage().setY(400-150-perso.getY());
        perso.getImage().setX(perso.getX()-camera.getX());
        mechant.getImage().setY(400-150-mechant.getY());
        mechant.getImage().setX(mechant.getX()-camera.getX());

    }



}