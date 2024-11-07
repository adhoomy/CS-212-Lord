public class Microwave extends Appliance {
    private int price;
    private int watts;

    public Microwave(String serialNum, int cost, int w) {
        serialNumber = serialNum;
        price = cost;
        watts = w;
    }

    public String toString() {
        return "Serial #" + serialNumber + ", Price: " + price + ", Watts: " + watts;
    }
}