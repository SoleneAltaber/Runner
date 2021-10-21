public class Camera {
    private int x;
    private int y;

    public Camera(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
