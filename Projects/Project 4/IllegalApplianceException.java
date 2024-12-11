public class IllegalApplianceException extends IllegalArgumentException {

    /**
     * creates an exception to be called when a serial number is invalid
     *
     * @param message
     */
    public IllegalApplianceException(String message) {
        super(message);
    }

}
