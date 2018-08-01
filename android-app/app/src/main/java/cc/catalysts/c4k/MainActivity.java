package cc.catalysts.c4k;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import org.json.JSONException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import cc.catalysts.c4k.entity.AirDetails;
import cc.catalysts.c4k.service.CoffeeService;
import cc.catalysts.c4k.service.LightService;
import cc.catalysts.c4k.service.TemperatureService;
import cc.catalysts.c4k.service.impl.CoffeeServiceImpl;
import cc.catalysts.c4k.service.impl.LightServiceImpl;
import cc.catalysts.c4k.service.impl.TemperatureServiceImpl;


public class MainActivity extends AppCompatActivity {

    private TemperatureService temperatureService = new TemperatureServiceImpl();
    private LightService lightService = new LightServiceImpl();
    private CoffeeService coffeeService = new CoffeeServiceImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button temperatureBtn = findViewById(R.id.temperatureBtn);
        temperatureBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AirDetails airDetails = null;
                    try{
                        airDetails = new AirDetailsTask().execute().get();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        String btnText;
                        if (airDetails != null){
                            btnText = airDetails.getTemperature()+getString(R.string.temperature_unit)+System.getProperty("line.separator")+
                                    airDetails.getHumidity()+getString(R.string.humidity_unit)+System.getProperty("line.separator")+
                                    airDetails.getPressure()+getString(R.string.pressure_unit);

                        }else{
                            btnText = "Error - retry";
                        }
                        temperatureBtn.setText(btnText);
                    }
            }
        });

        final Button coffeeBtn = findViewById(R.id.coffeBtn);
        coffeeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        coffeeService.makeCoffee();
                    }
                });
            }
        });

        final Button blueBtn = findViewById(R.id.blueBtn);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        lightService.setBlue();
                    }
                });
            }
        });

        final Button redBtn = findViewById(R.id.redBtn);
        redBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        lightService.setRed();
                    }
                });
            }
        });

        final Button greenBtn = findViewById(R.id.greenBtn);
        greenBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        lightService.setGreen();
                    }
                });
            }
        });

        final Button yellowBtn = findViewById(R.id.yellowBtn);
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        lightService.setYellow();
                    }
                });
            }
        });

    }

    private class AirDetailsTask extends AsyncTask<Void, Void, AirDetails> {
        @Override
        protected AirDetails doInBackground(Void... voids) {
            try{
                return temperatureService.getAirDetails();
            }catch (JSONException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(AirDetails airDetails) {
            super.onPostExecute(airDetails);
        }
    }
}
