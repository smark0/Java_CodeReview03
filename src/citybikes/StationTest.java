package citybikes;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    Station station4;
    User user4;
    Bike bike9;

    // i do not like JUnit.

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        station4 = new Station ("Simmering");
        user4 = new User("James", "Bond");
        mainApp.users.put(4,user4);
        mainApp.stations.put(4,station4);
        mainApp.bikes.put(9,bike9);
        user4.setRentedBike(9);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getIdCount() {
    }

    @org.junit.jupiter.api.Test
    void setIdCount() {
    }

    @org.junit.jupiter.api.Test
    void getStationID() {
    }

    @org.junit.jupiter.api.Test
    void setStationID() {
    }

    @org.junit.jupiter.api.Test
    void getStationLocation() {
    }

    @org.junit.jupiter.api.Test
    void setStationLocation() {
    }

    @org.junit.jupiter.api.Test
    void addBike() {
    }

    @org.junit.jupiter.api.Test
    void removeBike() {
    }

    //where am i going wrong?

    @org.junit.jupiter.api.Test
    void returnBike() {
        assertEquals(0,station4.getBikes().size());
        assertEquals(9,user4.getRentedBike());
        station4.returnBike(9);
        assertEquals(9,station4.getBikes().get(0));
        assertNull(user4.getRentedBike());
    }

    @org.junit.jupiter.api.Test
    void getBikes() {
    }

}