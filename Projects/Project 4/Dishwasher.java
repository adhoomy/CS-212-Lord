public class Dishwasher extends Appliance {
    private int price;
    private boolean undercounter;

    /**
     * data of dishwasher appliance are created and set
     *
     * @param serialNum
     * @param cost
     * @param undercount
     */
    public Dishwasher(String serialNum, int cost, boolean undercount) {
        serialNumber = serialNum;
        price = cost;
        undercounter = undercount;
    }

    /**
     * Retrieves the price of the dishwasher.
     *
     * @return the price of the dishwasher
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
        return "Serial #: " + serialNumber + ", Price: " + price + ", Undercounter: " + undercounter;
    }
}
