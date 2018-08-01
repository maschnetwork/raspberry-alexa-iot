package cc.catalysts.c4k.service.impl;

import org.json.JSONException;

import java.io.IOException;

import cc.catalysts.c4k.service.CoffeeService;
import cc.catalysts.c4k.service.RestService;

public class CoffeeServiceImpl implements CoffeeService {

    private RestService restService = new RestServiceImpl();

    @Override
    public void makeCoffee() {
        try{
            restService.makeCoffee();
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
