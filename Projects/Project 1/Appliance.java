public class Appliance {
    
    // where the serial number is stored
    private String serialNumber;

    // initialize appliance with a serial number
    public Appliance(String serialNum) {
        serialNumber = serialNum;
    }

    // gets the serial number
    public String getSerialNumber() {
        return serialNumber;
    }

    // sets the serial number
    public void setSerialNumber(String serialNum) {
        serialNumber = serialNum;
    }

    // compares serial numbers
    public int compareTo(Appliance other) {
        return this.serialNumber.compareTo(other.serialNumber);
    }

    // checks if serial numbers are equal
    public boolean equalTo(Appliance other) {
        return this.serialNumber.equals(other.serialNumber);
    }

    // defines the appliance
    public String toString() {
        String appliance = "";
        char letter = serialNumber.charAt(0);

        if(letter == 'R') appliance = "refrigerator";
        else if(letter == 'D') appliance = "dishwasher";
        else if(letter == 'M') appliance = "microwave";
        else appliance = "unknown";

        return appliance;
    }
}
