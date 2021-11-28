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
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
        // write your code here
    }
}

 //   public void start(Stage primaryStage){
   //     primaryStage.setTitle("Runner Solène <3");
     //   Group root = new Group();
        //Group welcomeGroup = new Group();
//      Scene scene = new GameScene(root, 600, 400);
        //Scene welcome = new Scene(welcomeGroup,600,400);
        //welcomeGroup.getChildren().add(new ImageView(new Image("img/debut1.png")));
        //primaryStage.setScene(welcome);

  //      primaryStage.setResizable(false);
    //    primaryStage.show();

    //}