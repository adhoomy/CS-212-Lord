public class Microwave extends Appliance {
    private int price;
    private int watts;

    /**
     * data of microwave are created and set
     *
     * @param serialNum
     * @param cost
     * @param w
     */
    public Microwave(String serialNum, int cost, int w) {
        serialNumber = serialNum;
        price = cost;
        watts = w;
    }

    /**
     * prints info for the appliance
     *
     * @return
     */
    public String toString() {
        return "Serial #: " + serialNumber + ", Price: " + price + ", Watts: " + watts;
    }
}