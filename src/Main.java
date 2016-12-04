import java.util.ArrayList;
import java.util.List;

import models.GameMap;
import models.JSONParser;
import models.Region;
import models.RegionJson;

/**
 * Created by svchost on 25/11/2016.
 */
public class Main {
	private static String COUNTRY_JSON_FILENAME = "jsondata/countries.json";

	public static void main(String[] args) {
		List<RegionJson> regionsJson = JSONParser.getRegions(COUNTRY_JSON_FILENAME);

		// Converting to Regions
		List<Region> regions = new ArrayList<>();
		for (RegionJson regionJson : regionsJson) {
			regions.add(new Region(regionJson));
		}

		// Finding neighbours for each region (essentially this is building a graph)
		GameMap map = new GameMap(regions);
	}
}
