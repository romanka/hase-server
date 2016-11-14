package service;

import java.io.*;
import java.net.URL;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;
import javax.json.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Productivity;
import model.Task;
import repositories.ProductivityRepository;
import repositories.UserRepository;

@Service("rescueTimeService")
public class RescueTimeService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProductivityRepository productivityRepo;

	/**
	 * 
	 * @param userToken
	 * @param from
	 *            (yyyy-mm-dd)
	 */
	public void getRTData(String userToken, String from) throws Exception {

		String apiKey = userRepo.findByToken(userToken).getRescueTimeKey();
		String url = "https://www.rescuetime.com/anapi/data?key=" + apiKey
				+ "&format=json&perspective=interval&interval=hour&restrict_begin=" + from;

		URL myurl = new URL(url);
		
		Integer year = Integer.parseInt(from.substring(0, 4));
		Integer month = Integer.parseInt(from.substring(5, 7));
		Integer day = Integer.parseInt(from.substring(8, 10));

		try (InputStream is = myurl.openStream(); JsonReader rdr = Json.createReader(is)) {
			JsonObject obj = rdr.readObject();
			JsonArray results = obj.getJsonArray("data");

			// TODO forloop to get all hours of this day - each hour has a
			// separe productivity entry!
			for (int i = 0; i < 24; i++) {
				Productivity newproductivity = new Productivity();
				newproductivity.setYear(year);
				newproductivity.setMonth(month);
				newproductivity.setDay(day);
				newproductivity.setHour(i);
				newproductivity.setUser(userRepo.findByToken(userToken));

				List<Task> tasklist = new ArrayList<Task>();

				for (JsonObject result : results.getJsonArray(2).getValuesAs(JsonObject.class)) {
					Task newtask = new Task();
					// TODO: Add values from JSON to task
					/* Data format of json response? What value is at what pisition?
					 * 0 --> timestamp with hour: YYYY-MM-DDHmm:00:00
					 * 1 -->
					 * 2 -->
					 * 3 -->
					 * 4 -->
					 * ...??
					 */
					
					
					// newtask.setTaskName(result);
					// newtask.setProductive(productive);
					// newtask.setValue(value);

					tasklist.add(newtask);

				}
				newproductivity.setTasks(tasklist);
			}

		}

	}

	public void parseRTString(String data) {

	}
}
