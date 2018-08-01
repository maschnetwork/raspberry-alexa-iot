package cc.catalysts.c4k.service;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;

public interface RestService {
    String getEndpoint();
    void makeCoffee() throws IOException, JSONException;
    void setLight(String color) throws JSONException, IOException;
    JSONObject getAirDetails() throws JSONException, IOException;
}
