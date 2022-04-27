package com.studying;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Weather extends Temp{

    private URL url = null;
    private HttpURLConnection connection = null;
    private InputStreamReader is = null;
    private BufferedReader reader = null;
    private StringBuilder buffer = new StringBuilder();
    public String result = null;
    private String weatherArray;
    public String city;

    Gson gson = new Gson();
    SimpleDateFormat formater = new SimpleDateFormat("dd");

    public void setCity(String city) {
        this.city = city;
    }

    public void getInfo(){
        try {

            String adress = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&cnt=5&appid=94c711ac5cd4f8c5b1da48fae97afb5a&units=metric";

            url = new URL(adress);
            connection = (HttpURLConnection) url.openConnection();

            is = new InputStreamReader(connection.getInputStream());
            reader = new BufferedReader(is);

            while ((result = reader.readLine()) != null) {
                buffer.append(result).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        weatherArray = buffer.toString();
    }

    public void currentWeather(){
        try {

            String adress = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=94c711ac5cd4f8c5b1da48fae97afb5a&units=metric&lang=ru";

            url = new URL(adress);
            connection = (HttpURLConnection) url.openConnection();

            is = new InputStreamReader(connection.getInputStream());
            reader = new BufferedReader(is);

            while ((result = reader.readLine()) != null) {
                buffer.append(result).append("\n");
            }
            currentWeatherForToday();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        try {
            if (reader != null)
                reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(buffer.toString());
            Temp temp_current = gson.fromJson(jsonObject.getJSONObject("main").toString(), Temp.class);

            temp = temp_current.temp;
            System.out.println("Температура сейчас: " + temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void currentWeatherForToday() {
        if(weatherArray!=null){
            try {

                JSONObject jsonObject = new JSONObject(weatherArray);
                Temp temp_today = gson.fromJson(jsonObject.getJSONArray("list").getJSONObject(0).getJSONObject("main").toString(), Temp.class);
                temp_max = temp_today.temp_max;
                temp_min = temp_today.temp_min;

                Date d = new Date(jsonObject.getJSONArray("list").getJSONObject(0).getInt("dt"));
                String date_c = formater.format(d);
                String date_c1 = formater.format(d);

                    for(int i = 0; date_c.equals(date_c1); i++) {
                        String array = jsonObject.getJSONArray("list").getJSONObject(i).toString();
                        JSONObject wa = new JSONObject(array);

                        Date d1 = new Date(jsonObject.getJSONArray("list").getJSONObject(i).getInt("dt"));
                        date_c1 = formater.format(d1);
                        System.out.println(date_c1);

                        double max = wa.getJSONObject("main").getDouble("temp_max");
                        double min = wa.getJSONObject("main").getDouble("temp_min");

                        if(max>temp_max){
                            temp_max = max;
                        }
                        if(min<temp_min){
                            temp_min = min;
                        }
                    }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        System.out.println(temp_max + " " + temp_min);
    }
}
