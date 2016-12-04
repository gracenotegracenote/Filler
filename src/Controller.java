import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.GameMap;
import models.JSONParser;
import models.Player;
import models.Region;
import models.RegionJson;
import views.Pane;

/**
 * Created by gracenote on 04-Dec-16.
 */
public class Controller extends Application {
	private GameMap map;

	private Player currentPlayer;
	private boolean isAi;


	public Controller() {
		List<RegionJson> regionsJson = JSONParser.getRegions(Config.REGION_JSON_FILENAME);

		// Converting to Regions
		List<Region> regions = new ArrayList<>();
		for (RegionJson regionJson : regionsJson) {
			regions.add(new Region(regionJson));
		}

		map = new GameMap(regions);

		isAi = false; // TODO: DO
	}


	@Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, Config.SCENE_WIDTH, Config.SCENE_HEIGHT);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


	public static void main(String[] args) {
		launch(args);
	}
}
