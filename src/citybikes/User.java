package citybikes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class User {
    private static int idCount = 1; //hardcoding start id
    private int userID;
    private String firstName;
    private String lastName;
    private Integer rentedBike;
    private Rent rent;
    private ArrayList<Rent> rents = new ArrayList<>();

    public User (String firstName, String lastName) {
        this.userID = idCount++;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){} //to be able to see which User has the bike

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        User.idCount = idCount;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void rentBike(Integer bikeID) {
        if (mainApp.bikes.get(bikeID).getBikeStatus() == Bike.bikeState.CanBeRented) {
            mainApp.checkStation(bikeID);
            this.rentedBike = bikeID;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bikeID, today);
            this.rents.add(this.rent);
        } else {
            System.out.println("This bike can't be rented, sorry!");
        }
    }

    public Integer getRentedBike(){
        return this.rentedBike;
    }


    public void setRentedBike(Integer bikeID){ //to be able to see which user has which bike - pass bikeId
        this.rentedBike = bikeID;
    }

    public int getUserId(){
        return this.userID;
    }

    //when user returns bike set currently rented bike to 0

    public void removeBike(Integer bikeID){
        this.rent.setRentEnd();
        this.rentedBike = null;
    }

    public void allBikesRentedByUser(){

        //SDF is really interesting

        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm dd.MM.yyyy");
        String printName = this.firstName +" "+ this.lastName;
        System.out.printf("%S" + "%17s" + "%28s%n", "NAME: " + printName, "Start", "End");
        System.out.println("----------------------------------------------------------------------");
        for (Rent rent :rents){
            System.out.printf("Bike" + "%2S" + "%34S" + "%30S%n", rent.getBikeID(), sdf.format(rent.getRentStart().getTime()), sdf.format(rent.getRentEnd().getTime()));

        }
    }
}
