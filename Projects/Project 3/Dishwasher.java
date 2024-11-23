public class Dishwasher extends Appliance {
    private int price;
    private boolean undercounter;

    // data of dishwasher are created and set
    public Dishwasher(String serialNum, int cost, boolean undercount) {
        serialNumber = serialNum;
        price = cost;
        undercounter = undercount;
    }

    // prints info for the appliance
    public String toString() {
        return "Serial #: " + serialNumber + ", Price: " + price + ", Undercounter: " + undercounter;
    }
}