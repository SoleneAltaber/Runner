import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public void start(Stage primaryStage){
        primaryStage.setTitle("Runner Solène <3");
        Group root = new Group();
        Scene scene = new GameScene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}