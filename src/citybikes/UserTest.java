package citybikes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    Station station4;
    User user4;
    Bike bike9;


    @BeforeEach

    void setUp() {
        bike9 = new Bike("black", Bike.bikeState.CanBeRented);
        mainApp.bikes.put(9,bike9);
        station4 = new Station("Simmering");
        mainApp.stations.put(9,station4);
        station4.addBike(9);
        user4 = new User("James", "Bond");

    }

    @Test
    void rentBike() {
        assertNull(user4.getRentedBike());
        assertEquals(1, station4.getBikes().size());
        user4.rentBike(9);
        assertEquals(9,user4.getRentedBike());
        assertEquals(0,station4.getBikes().size());

    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void getIdCount() {
    }

    @Test
    void setIdCount() {
    }

    @Test
    void getUserID() {
    }

    @Test
    void setUserID() {
    }

    @Test
    void getFirstName() {
    }

    @Test
    void setFirstName() {
    }

    @Test
    void getLastName() {
    }

    @Test
    void setLastName() {
    }

    @Test
    void getRentedBike() {
    }

    @Test
    void setRentedBike() {
    }

    @Test
    void getUserId() {
    }

    @Test
    void removeBike() {
    }

    @Test
    void allBikesRentedByUser() {
    }
}