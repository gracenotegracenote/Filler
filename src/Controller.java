import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.Pane;

/**
 * Created by gracenote on 04-Dec-16.
 */
public class Controller extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
