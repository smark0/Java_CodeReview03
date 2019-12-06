package citybikes;

import java.util.HashMap;
import java.util.Map;

public class mainApp {

    public static HashMap<Integer, Bike> bikes = new HashMap<>();
    public static HashMap<Integer, Station> stations = new HashMap<>();
    public static HashMap<Integer, User> users = new HashMap<>();


    public static void main(String[] args) {
        Bike bike1 = new Bike("black", Bike.bikeState.CanNotBeRented);
        Bike bike2 = new Bike("blue", Bike.bikeState.CanBeRented);
        Bike bike3 = new Bike("brown", Bike.bikeState.CanBeRented);
        Bike bike4 = new Bike("green", Bike.bikeState.CanNotBeRented);
        Bike bike5 = new Bike("red", Bike.bikeState.CanBeRented);
        Bike bike6 = new Bike("green", Bike.bikeState.CanBeRented);
        Bike bike7 = new Bike("brown", Bike.bikeState.CanBeRented);
        Bike bike8 = new Bike("turquoise", Bike.bikeState.InService);

        //create all bikes
        bikes.put(bike1.getBikeID(), bike1);
        bikes.put(bike2.getBikeID(), bike2);
        bikes.put(bike3.getBikeID(), bike3);
        bikes.put(bike4.getBikeID(), bike4);
        bikes.put(bike5.getBikeID(), bike5);
        bikes.put(bike6.getBikeID(), bike6);
        bikes.put(bike7.getBikeID(), bike7);
        bikes.put(bike8.getBikeID(), bike8);

        //define all stations
        Station station1 = new Station("Kettenbrückengasse, U4");
        Station station2 = new Station("Floridsdorf. U6");
        Station station3 = new Station("Stephansplatz, U1");

        //create all stations

        stations.put(station1.getStationID(), station1);
        stations.put(station2.getStationID(), station2);
        stations.put(station3.getStationID(), station3);

        //adds bikes to stations
        station1.addBike(1);
        station1.addBike(2);
        station1.addBike(3);
        station2.addBike(4);
        station2.addBike(5);
        station2.addBike(6);
        station2.addBike(7);

        //create all user
        User user1 = new User("Tim", "Jochmann");
        User user2 = new User("Struppi", "Gangnam");
        User user3 = new User("Hans", "Hütte");

        //define users
        users.put(user1.getUserID(), user1);
        users.put(user2.getUserID(), user2);
        users.put(user3.getUserID(), user3);

        System.out.println("\nWelcome to CF Bike Rental Service! \n");

        user1.rentBike(2);
        System.out.println("You chose Bike Nr: " + user1.getRentedBike() + "\n");
        System.out.println("Remaining Bikes in Station 1: "+ station1.getBikes().toString() + "\n");
        station1.returnBike(2);

        user1.rentBike(3);
        System.out.println("You chose Bike Nr: " + user1.getRentedBike() + "\n");
        System.out.println("Remaining Bikes in Station 1: " + station1.getBikes().toString() + "\n");
        System.out.println(("Remaining Bikes in Station 2: "+station2.getBikes().toString()) + "\n");
        station1.returnBike(3);

        user1.rentBike(5);
        station1.returnBike(5);

        if (user1.getRentedBike() == null) {
            System.out.println("You do not have any bike rented!\n");
        } else {
            System.out.println("You chose Bike Nr: " + user1.getRentedBike() + "\n");
        }

        System.out.println("Remaining Bikes in Station 1: " + station1.getBikes().toString() + "\n");
        System.out.println(("Remaining Bikes in Station 2: "+station2.getBikes().toString()) + "\n");

        user2.rentBike(7);
        station1.returnBike(7);
        System.out.println("Remaining Bikes in Station 1: " + station1.getBikes().toString() + "\n");

        user2.rentBike(6);
        station3.returnBike(6);
        System.out.println("Remaining Bikes in Station 3: " + station3.getBikes().toString() + "\n");


        user1.allBikesRentedByUser();

        System.out.println("\nThank you for using our service.");

    }

    //create new station and check it

    public static void checkStation(Integer bikeID) {
        Station station = new Station();
        for (Map.Entry<Integer, Station> entry : stations.entrySet()) {
            if (entry.getValue().getBikes().contains(bikeID)) {
                station = entry.getValue();
                break;
            }
        }
        station.removeBike(bikeID);
    }

    public static void checkUser(Integer bikeID){
        User user = new User();
        for(Map.Entry<Integer, User> entry: users.entrySet()){
            if(entry.getValue().getRentedBike() == bikeID){
                user = entry.getValue();
                break;
            }
        }
        user.removeBike(bikeID);
    }
}
