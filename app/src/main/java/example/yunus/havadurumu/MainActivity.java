package example.yunus.havadurumu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Adapter adapter;
    ArrayList<Weather> weathers =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter=new Adapter(this, weathers);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        verileriGetir();
    }

    public void verileriGetir()
    {
        Base.getInstance().fetchWeather().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response)
            {

                JsonObject objectA = response.body();

                JsonArray resultArray = objectA.get("list").getAsJsonArray();
                for (int i = 0; i < resultArray.size(); i++)
                {
                    Weather weather = new Weather();
                    //aciklamalar
                    JsonObject object= resultArray.get(i).getAsJsonObject();
                    JsonArray aciklama=object.get("weather").getAsJsonArray();
                    for(int a=0;a<aciklama.size();a++)
                    {
                        JsonObject aciklamalar= aciklama.get(a).getAsJsonObject();
                        weather.aciklama = aciklamalar.get("description").getAsString();
                        weather.tanim = aciklamalar.get("main").getAsString();

                    }

                    //sicaklik
                    JsonObject sicaklik=object.get("main").getAsJsonObject();
                    weather.sicaklik=sicaklik.get("temp").getAsDouble();
                    weather.sicaklik=weather.sicaklik-232.0; //Kelvinden Celcius'a dönüş

                    //sehiri getir. Bizde burası Moskova olacak hep.
                    JsonObject sehir=objectA.get("city").getAsJsonObject();
                    weather.sehir=sehir.get("name").getAsString();
                    weathers.add(weather);
                    adapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t)
            {
                Toast.makeText(MainActivity.this,"Hay aksi! Bir sorun oluştu.",Toast.LENGTH_LONG).show();
            }
        });
    }
}
