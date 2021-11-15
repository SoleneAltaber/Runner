import javafx.geometry.Rectangle2D;

public class Foe extends AnimatedThings {

    public Foe(String fileName, double x, double y) {
        super(fileName, x, y);
    }
    public void update(long time){
        x=x-2;
        long index= (time/durationFrame)%2;
        image.setViewport(new Rectangle2D(index*100,0,100,100));


    }

}