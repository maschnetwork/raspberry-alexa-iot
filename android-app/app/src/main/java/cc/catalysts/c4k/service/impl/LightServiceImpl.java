package cc.catalysts.c4k.service.impl;

import android.util.Log;

import org.json.JSONException;

import java.io.IOException;

import cc.catalysts.c4k.service.LightService;
import cc.catalysts.c4k.service.RestService;

public class LightServiceImpl implements LightService {

    private RestService restService = new RestServiceImpl();

    @Override
    public void setGreen() {
        try{
            restService.setLight("grün");
        }catch(JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setBlue() {
        try{
            restService.setLight("blau");
        }catch(JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setYellow() {
        try{
            restService.setLight("gelb");
        }catch(JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setRed() {
        try{
            restService.setLight("rot");
        }catch(JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
