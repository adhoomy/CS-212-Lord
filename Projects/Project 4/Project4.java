public class Project4 {

    /**
     * runs the program, a gui that lists organized serial numbers for appliances
     *
     * @param args
     */
    public static void main(String[] args) {
        // creates gui and adds the serial numbers sorted
        ApplianceGUI gui = new ApplianceGUI();
        gui.printSerialGUI(gui);
    }

}
