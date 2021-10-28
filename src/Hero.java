import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Hero extends AnimatedThings{

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);

    }
    public void update(long time){
        x=x+10;
        long index= (time/durationFrame)%6;
        image.setViewport(new Rectangle2D(index*85,0,80,100));
    }

    public void render(long time){
        time=time/3000000;
        this.getImage().setImage(new Image("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros.png"));

    }

}
