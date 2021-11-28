import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;


public class WelcomeScene extends Scene {

    private final StaticThings fond = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\fond.png",800,600);
    private final StaticThings debut = new StaticThings("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\debut1.png",400,400);
    private double v;
    private double v1;
    public boolean debJeu=true;

    public WelcomeScene(Group group, double v, double v1) {

        super(group, v, v1);
        this.v = v;
        this.v1 = v1;
        group.getChildren().add(fond.getImage());
        group.getChildren().add(debut.getImage());

    }
    void findebut() {
        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                debJeu = false;
            }
        });
    }
}
