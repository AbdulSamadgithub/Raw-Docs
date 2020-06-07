package com.bwap.weatherapp.WeatherApp.controller;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * This class works on fetching the data from the Open weather website
 * It sends different requests and than fetches the data from the web
 * the open weather assigns a user a free API key that can be used to access the data from their website
 *
 */

@Service
public class WeatherService {

    private OkHttpClient client;
    private Response response;
    private String cityName;
    private String unit;
    private String APIkey1 = "bfa9bfadf2597fbdb2bc470f00444618";
    private String APIkey2 = "e36a596efd9c9e06207b70fddcad1878";
    private String APIkey3 = "8a1eb14af62846141ac3121e806e1493";
    private String APIkey4 = "ca29d04c2cb83097a0fea60233537eaf";
    private String APIkey5 = "9624d56d5c4dba1f394c59e3f6a35f02";
    private String APIkey6 = "5a2ed25451ea1fe88c690baee7a9e8dc";
    private String APIkey7 = "092df2941f03f1504b8c3b2fab6cd0f4";


    /**
     * @return Weather Information
     * It sends request using the url that has a scheme
     * the url fetches the data
     * In case there is no Response there will be an exception and that is handled in the code
     *
     * This method gives random information in the form of json object
     * the data further can be extracted for example
     * 1- All data about weather will be available in the single object JSONObject in our case
     * like this method returns JSONObject that have all the information included in it about data
     * further methods are implemented on this JSONObject to get the desired data like wind humidity
     *
     */
    public JSONObject getWeather() {

        client = new OkHttpClient();

        /**
         * url scheme :: "http://api.openweathermap.org/data/2.5/weather?q="+Bhakkar+"&units="+getUnit()+"&appid="+12897389127iufsdfkjhf
         * Here the Request is being sent
         *
         */
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+getCityName()+"&units="+getUnit()+"&appid="+APIkey6)
                .build();

        //Exception Handled in case if there is no Response
        try {
            response = client.newCall(request).execute();

            //The JSONOBJECT in the method is returned here
            return new JSONObject(response.body().string());

        }catch (IOException | JSONException e){
            e.printStackTrace();

        }
        //if nothing returned in the try statement this method will return nothing
        return null;
    }

    /**
     *
     * @return weather Json Array
     * @throws JSONException
     *jSON is used to exchange data between server and the web application
     *sometimes between Application that operate along with web
     *
     *
     */
    public JSONArray returnWeatherArray() throws JSONException {
        JSONArray weatherJsonArray = getWeather().getJSONArray("weather");
        return weatherJsonArray;
    }

    public JSONObject returnMainObject() throws JSONException {
        JSONObject mainObject = getWeather().getJSONObject("main");
        return mainObject;
    }


    public JSONObject returnWindObject() throws JSONException {
        JSONObject wind = getWeather().getJSONObject("wind");
        return wind;
        }

    //This method  is never used anywhere
    public JSONObject returnSysObject() throws JSONException{
        JSONObject sys = getWeather().getJSONObject("sys");
        return sys;
        }

    //it is used in the getWeather() Methond on the top to get the city name
    public String getCityName() {
        return cityName;
    }


    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *Units are Celcius Farenheit etc
     *if we donot set the units the defaults will be in the Kelvin format
     *
     */
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
