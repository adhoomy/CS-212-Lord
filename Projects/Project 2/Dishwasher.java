public class Dishwasher extends Appliance {
    private int price;
    private char undercounter;

    public Dishwasher(String serialNum, int cost, char undercount) {
        serialNumber = serialNum;
        price = cost;
        undercounter = undercount;
    }

    public String toString() {
        return "Serial #" + serialNumber + ", Price: " + price + ", Undercounter: " + undercounter;
    }
}