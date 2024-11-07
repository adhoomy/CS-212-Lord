public class Refrigerator extends Appliance {
    private int price;
    private int cubicFeet;

    public Refrigerator(String serialNum, int cost, int cubicFt) {
        serialNumber = serialNum;
        price = cost;
        cubicFeet = cubicFt;
    }

    public String toString() {
        return "Serial #" + serialNumber + ", Price: " + price + ", Cubic Feet: " + cubicFeet;
    }
}
