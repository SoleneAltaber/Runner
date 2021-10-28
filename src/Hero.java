import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Hero extends AnimatedThings{
    private double yVitess=1;

    public Hero (String fileName, double x, double y) {
        super(fileName, x, y);

    }

    public double getyVitess() {
        return yVitess;
    }

    public void update(long time){
        x=x+10;
        long index= (time/durationFrame)%6;
        image.setViewport(new Rectangle2D(index*85,0,80,100));
        y+=yVitess;
        yVitess-=0.5; //gravité
        if(y<45){
            y=45;
            yVitess*=-0.3;
        }
    }
    public void jump (){

        yVitess+=10;
    }
    public void render(long time){
        time=time/3000000;
        this.getImage().setImage(new Image("C:\\Users\\solen\\Desktop\\soso\\Ecole\\ENSEA_2A\\Runner\\img\\heros.png"));

    }

}
