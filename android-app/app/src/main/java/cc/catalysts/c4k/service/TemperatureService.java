package cc.catalysts.c4k.service;

import org.json.JSONException;

import java.io.IOException;

import cc.catalysts.c4k.entity.AirDetails;

public interface TemperatureService {

    AirDetails getAirDetails() throws JSONException, IOException;

}
