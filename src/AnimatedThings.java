import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThings {
    protected double x;
    protected double y;
    private String fileName;
    protected ImageView image;
    private int attitude;
    private int index;
    protected int durationFrame=100000000;


    public AnimatedThings(String fileName, double x, double y) {
        this.x = x;
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
}