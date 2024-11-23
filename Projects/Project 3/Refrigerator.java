public class Refrigerator extends Appliance {
    private int price;
    private int cubicFeet;

    // data of refrigerator are created and set
    public Refrigerator(String serialNum, int cost, int cubicFt) {
        serialNumber = serialNum;
        price = cost;
        cubicFeet = cubicFt;
    }

    // prints info for the appliance
    public String toString() {
        return "Serial #: " + serialNumber + ", Price: " + price + ", Cubic Feet: " + cubicFeet;
    }
}
