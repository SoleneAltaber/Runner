import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThings {

    private double x;
    private double y;
    private String fileName;
    private ImageView image;


    public StaticThings (String fileName, double x, double y) {
        this.x =x;
        this.y = y;
        this.fileName = fileName;
        this.image = new ImageView(new Image(fileName));
    }

    public ImageView getImage() {
        return image;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
