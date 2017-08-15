package example.yunus.havadurumu;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yunus on 15.08.2017.
 */

public interface Service
{
    @GET("data/2.5/forecast?id=524901&APPID=4a8b6e0e9ff83dba88934c351b370158")
    Call<JsonObject> fetchWeather();
}
