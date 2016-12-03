package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20/11/2016.
 */
public class JSONParser {
	public static List<RegionJson> getRegions(String filename) {
		List<RegionJson> regions = new ArrayList<>();

		try (Reader reader = new InputStreamReader(new FileInputStream(filename))) {
			Gson gson = new Gson();
			regions = gson.fromJson(reader, new TypeToken<List<RegionJson>>() {}.getType());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return regions;
	}
}