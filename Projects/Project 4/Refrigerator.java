public class Refrigerator extends Appliance {
    private int price;
    private int cubicFeet;

    /**
     * data of refrigerator are created and set
     *
     * @param serialNum
     * @param cost
     * @param cubicFt
     */
    public Refrigerator(String serialNum, int cost, int cubicFt) {
        serialNumber = serialNum;
        price = cost;
        cubicFeet = cubicFt;
    }

    /**
     * Retrieves the price of the refrigerator.
     *
     * @return the price of the refrigerator
     */
    public int getPrice() {
        return price;
    }

    /**
     * prints info for the appliance
     *
     * @return
     */
    public String toString() {
        return "Serial #: " + serialNumber + ", Price: " + price + ", Cubic Feet: " + cubicFeet;
    }
}
