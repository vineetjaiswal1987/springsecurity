package com.edigest.journalAppLatest.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
    @Getter
    @Setter
    private Current current;

    @Getter
    @Setter
    public class Current{
        private int is_day;
        private String wind_dir;
        private int humidity;
        private int cloud;
    }





}
