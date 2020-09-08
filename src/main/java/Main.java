import com.google.gson.Gson;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        String city;
        System.out.println("Enter city: ");
        Scanner scanner = new Scanner(System.in);
        city = scanner.nextLine();
        String charset = "UTF-8";
        String apiKey = "346a1b6d1bc8c4a8fa8e1e942ffb0939";
        String query = " https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&units=metric" + "&apiKey=" + apiKey;

        //"https://api.openweathermap.org/data/2.5/weather?q="
        Gson gson = new Gson();
        URLConnection urlConnection = null;

        try {
            URL url = new URL(query);
            urlConnection = url.openConnection();
            urlConnection.connect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader data = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String linesOfData = data.readLine();
        System.out.println(linesOfData);

        //WeatherConditions weatherConditions = gson.fromJson(linesOfData, WeatherConditions.class);
        WeatherForecast weatherForecast = gson.fromJson(linesOfData, WeatherForecast.class);
        WindSpeed windSpeed = new WindSpeed();

        System.out.println(weatherForecast.getCondition());
        for (WeatherConditions item : weatherForecast.getCondition()) {
            item.getName();
            item.getCondition();
            item.getId();
            item.getDt_txt();
            item.getWind();

        }


        //System.out.println(weatherConditions);

        //
        // System.out.println(weatherConditions.toString());//TODO this one needs to be displayed.


    }

}
