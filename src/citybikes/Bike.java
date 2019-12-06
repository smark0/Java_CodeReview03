package citybikes;

public class Bike {
    private static int idCount = 1; //hardcoding start id
    private int bikeID;
    private String bikeColor;
    private bikeState bikeStatus;
    public enum bikeState {
        CanBeRented, CanNotBeRented, InService, Discarded
    }

    public Bike(String bikeColor, bikeState bikeStatus) {
        this.bikeID = idCount++;
        this.bikeColor = bikeColor;
        this.bikeStatus = bikeStatus;
    }

    public static int getIdCount() {
        return idCount;
    }

    public static void setIdCount(int idCount) {
        Bike.idCount = idCount;
    }

    public int getBikeID() {
        return this.bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public String getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }

    public bikeState getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(bikeState bikeStatus) {
        this.bikeStatus = bikeStatus;
    }

}
