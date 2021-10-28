import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        render();

    }

    private Camera camera;
    private StaticThings left = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private StaticThings right = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\desert.png",800,600);
    private Hero perso = new Hero("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros.png", 300, 0);
    private double v;
    private double v1;
    AnimationTimer timer= new AnimationTimer() {
        public void handle(long time) {
            perso.update(time);
            camera.update(time);
            render();
        }
    };

    public void render(){
        double xCam=camera.getX();
        double offsetLeft=xCam%left.getX();
        System.out.println("Heros en : "+perso.getX());
        left.getImage().setX(-offsetLeft);
        right.getImage().setX(800-offsetLeft);
        perso.getImage().setY(400-150);
        perso.getImage().setX(perso.getX()-camera.getX());

    }



}