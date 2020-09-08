import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WeatherConditions {

    Gson gson;

    private int id;
    private String name;
    @SerializedName("main")
    private Map<String, Float> measurements ;
    private List<WeatherForecastItem> weather;
    private String dt_txt;
    private WindSpeed wind;



    //Getters
    public String getCondition(){ return weather.get(0).getDescription(); }
    public int getId(){ return id; }
    public String getName() { return name; }
    public String getMeasurements() { return toString(); }
    public String getDt_txt(){ return dt_txt; }
    public WindSpeed getWind(){ return wind; }




    @Override
    public String toString(){
        Float min = measurements.get("temp_min");
        Float max = measurements.get("temp_max");
        Float temperature = measurements.get("temp");



        String weatherItems = "Min: "+ min + " & Max: " + max + "\n"
                + "Current Temperature: " + temperature + "\n"
                + "Time: " + dt_txt + "\n"
                + "Condition: " + getCondition() + "\n"
                + "Wind speed: " + getWind();


        return weatherItems;
    }






}
