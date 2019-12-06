package citybikes;

import java.util.ArrayList;

public class Station {
    private static int idCount = 1; //hardcoding start id
    private int stationID;
    private String stationLocation;
    private ArrayList<Integer> bikes;

    public Station(String stationLocation) {
        this.stationID = idCount++;
        this.stationLocation = stationLocation;
        this.bikes = new ArrayList<>();
    }

    public Station(){}

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Station.idCount = idCount;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }

    //bikes to station
    public void addBike(Integer bikeID) {
        this.bikes.add(bikeID);
    }

    //bike from stations
    public void removeBike(Integer bikeID) {
        this.bikes.remove(bikeID);
    }

    public ArrayList<Integer> getBikes() {
        return this.bikes;
    }

    public void returnBike(Integer bikeID) {
        if (this.bikes.size() < 5) {
            addBike(bikeID);
            mainApp.checkUser(bikeID);
        } else {
            System.out.println("Sorry, this station can't take any more bikes!");
        }
    }

}
