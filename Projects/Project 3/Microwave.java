public class Microwave extends Appliance {
    private int price;
    private int watts;

    // data of microwave are created and set
    public Microwave(String serialNum, int cost, int w) {
        serialNumber = serialNum;
        price = cost;
        watts = w;
    }

    // prints info for the appliance
    public String toString() {
        return "Serial #: " + serialNumber + ", Price: " + price + ", Watts: " + watts;
    }
}