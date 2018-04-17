package cz.uhk.fim.kozakev1.dbs_and_location.model;

/**
 * Created by kozakev1 on 16.04.2018.
 */

public class Pub {

    String name;
    double lat;
    double lng;

    public Pub(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
