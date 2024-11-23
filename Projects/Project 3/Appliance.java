public abstract class Appliance {
    
    // where the serial number is stored
    protected String serialNumber;

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

}
