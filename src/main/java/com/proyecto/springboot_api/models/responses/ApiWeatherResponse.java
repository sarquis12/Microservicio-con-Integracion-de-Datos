package com.proyecto.springboot_api.models.responses;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;



public class ApiWeatherResponse {

    private double latitude;
    private double longitude;

    @JsonProperty("generationtime_ms")
    private double generationTimeMs;

    @JsonProperty("utc_offset_seconds")
    private int utcOffsetSeconds;
    private String timezone;

    @JsonProperty("timezone_abbreviation")
    private String timezoneAbbreviation;

    private double elevation;

    @JsonProperty("current_weather_units")
    private CurrentWeatherUnits currentWeatherUnits;

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    // Getters y Setters
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getGenerationTimeMs() { return generationTimeMs; }
    public void setGenerationTimeMs(double generationTimeMs) { this.generationTimeMs = generationTimeMs; }

    public int getUtcOffsetSeconds() { return utcOffsetSeconds; }
    public void setUtcOffsetSeconds(int utcOffsetSeconds) { this.utcOffsetSeconds = utcOffsetSeconds; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }

    public String getTimezoneAbbreviation() { return timezoneAbbreviation; }
    public void setTimezoneAbbreviation(String timezoneAbbreviation) { this.timezoneAbbreviation = timezoneAbbreviation; }

    public double getElevation() { return elevation; }
    public void setElevation(double elevation) { this.elevation = elevation; }

    public CurrentWeatherUnits getCurrentWeatherUnits() { return currentWeatherUnits; }
    public void setCurrentWeatherUnits(CurrentWeatherUnits currentWeatherUnits) { this.currentWeatherUnits = currentWeatherUnits; }

    public CurrentWeather getCurrentWeather() { return currentWeather; }
    public void setCurrentWeather(CurrentWeather currentWeather) { this.currentWeather = currentWeather; }

    // Clases internas
    public static class CurrentWeather {
        private String time;
        private int interval;
        private double temperature;
        private double windspeed;
        private int winddirection;
        @JsonProperty("is_day")
        private int isDay;
        private int weathercode;

        // Getters y Setters
        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }

        public int getInterval() { return interval; }
        public void setInterval(int interval) { this.interval = interval; }

        public double getTemperature() { return temperature; }
        public void setTemperature(double temperature) { this.temperature = temperature; }

        public double getWindspeed() { return windspeed; }
        public void setWindspeed(double windspeed) { this.windspeed = windspeed; }

        public int getWinddirection() { return winddirection; }
        public void setWinddirection(int winddirection) { this.winddirection = winddirection; }

        public int getIsDay() { return isDay; }
        public void setIsDay(int isDay) { this.isDay = isDay; }

        public int getWeathercode() { return weathercode; }
        public void setWeathercode(int weathercode) { this.weathercode = weathercode; }
    }

    
    public static class CurrentWeatherUnits {
        private String time;
        private String interval;
        private String temperature;
        private String windspeed;
        private String winddirection;
        
        @JsonProperty("is_day")
        private String isDay;
        
        private String weathercode;

        // Getters y Setters
        public String getTime() { return time; }
        public void setTime(String time) { this.time = time; }

        public String getInterval() { return interval; }
        public void setInterval(String interval) { this.interval = interval; }

        public String getTemperature() { return temperature; }
        public void setTemperature(String temperature) { this.temperature = temperature; }

        public String getWindspeed() { return windspeed; }
        public void setWindspeed(String windspeed) { this.windspeed = windspeed; }

        public String getWinddirection() { return winddirection; }
        public void setWinddirection(String winddirection) { this.winddirection = winddirection; }

        public String getIsDay() { return isDay; }
        public void setIsDay(String isDay) { this.isDay = isDay; }

        public String getWeathercode() { return weathercode; }
        public void setWeathercode(String weathercode) { this.weathercode = weathercode; }
    }
}
