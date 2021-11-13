import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThings {

    public Foe(String fileName, double x, double y) {
        super(fileName, x, y);
    }
    public void update(long time){
        x=x-2;
        long index= (time/durationFrame)%6;
        image.setViewport(new Rectangle2D(0,0,50,33));

    }

}