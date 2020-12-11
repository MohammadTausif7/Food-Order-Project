package com.example.foodordersystem.Utils;

import com.example.foodordersystem.Retrofit.IFoodOrderAPI;
import com.example.foodordersystem.Retrofit.RetrofitClient;

public class Common {
    private static final String BASE_URL = "http://10.0.2.2/foodorder/";

    public static IFoodOrderAPI getAPI() {
        return RetrofitClient.getClient(BASE_URL).create(IFoodOrderAPI.class);
    }
}
