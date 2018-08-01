package cc.catalysts.c4k.service.impl;

import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


import cc.catalysts.c4k.service.RestService;

public class RestServiceImpl implements RestService {

    private static final String ENDPOINT = "http://c4k-iot.us.openode.io";
    private static final String LIGHTS = "/light";
    private static final String COFFEE = "/coffee";
    private static final String TEMPERATURE = "/temperature";


    @Override
    public String getEndpoint() {
        return ENDPOINT;
    }

    @Override
    public void makeCoffee() throws IOException, JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state","false");

        URL url = new URL(ENDPOINT+COFFEE);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("content-type", "application/json; charset=utf-8");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        writeToConnection(connection, jsonObject);
    }

    @Override
    public void setLight(String color) throws JSONException, IOException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("color",color);

        URL url = new URL(ENDPOINT+LIGHTS);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("content-type", "application/json; charset=utf-8");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        writeToConnection(connection, jsonObject);
    }

    @Override
    public JSONObject getAirDetails() throws JSONException, IOException{

        URL url = new URL(ENDPOINT+TEMPERATURE);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);

        return readFromConnection(connection);
    }

    private void writeToConnection(HttpURLConnection connection, JSONObject jsonObject) throws IOException{
        OutputStream os = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(jsonObject.toString());
        writer.flush();
        writer.close();
        os.close();
        Log.i("RESULT:",connection.getResponseCode()+"");

        connection.connect();
    }

    private JSONObject readFromConnection(HttpURLConnection connection) throws IOException, JSONException{
        InputStream in = new BufferedInputStream(connection.getInputStream());

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        StringBuilder result = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        Log.i("RESULT:",result.toString());
        return new JSONObject(result.toString());
    }
}
