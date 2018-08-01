package cc.catalysts.c4k.service.impl;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cc.catalysts.c4k.entity.AirDetails;
import cc.catalysts.c4k.service.RestService;
import cc.catalysts.c4k.service.TemperatureService;

public class TemperatureServiceImpl implements TemperatureService {

    private RestService restService = new RestServiceImpl();

    @Override
    public AirDetails getAirDetails() throws JSONException, IOException{
        JSONObject jsonObject = restService.getAirDetails();
        if (jsonObject != null && !jsonObject.get("temperature").equals(0)) {
            return new AirDetails((double) jsonObject.get("temperature"),(double) jsonObject.get("humidity"),(double) jsonObject.get("pressure"));
        }
        return null;
    }
}
