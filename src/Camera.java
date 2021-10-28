public class Camera {

    private double x;
    private double y;
    private AnimatedThings CentrCam;


    public Camera (double x, double y, AnimatedThings CentrCam) {
        this.x = x;
        this.y = y;
        this.CentrCam=CentrCam;
    }

    public void update(long time){
        this.x=CentrCam.getX();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.x + "," + this.y;
    }


}