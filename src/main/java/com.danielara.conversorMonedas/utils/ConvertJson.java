package com.danielara.conversorMonedas.utils;

import com.danielara.conversorMonedas.models.ExchanGerateResponse;
import com.google.gson.Gson;

public class ConvertJson {
    public static ExchanGerateResponse convertJson(String json)
    {
        Gson gson = new Gson();
        return gson.fromJson(json, ExchanGerateResponse.class);
    }
}
