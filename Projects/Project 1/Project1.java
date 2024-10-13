import java.awt.GridLayout;
import javax.swing.*;

public class Project1 {

    private static void getSerialNumbers(JFrame theFrame, JTextArea fridges, JTextArea washers, JTextArea waves) {
        Appliance[] appliances = new Appliance[100];
        int applianceNum = 0;

        TextFileInput in = new TextFileInput("data.txt");
        String line = in.readLine();
        while(line != null && applianceNum < appliances.length-1) {
            appliances[applianceNum++] = new Appliance(line);
            if(appliances[applianceNum].toString().equals("refrigerator")) {
                fridges.append(line);
            }
            if(appliances[applianceNum].toString().equals("dishwashers")) {
                washers.append(line);
            }
            if(appliances[applianceNum].toString().equals("microwaves")) {
                waves.append(line);
            }
            line = in.readLine();
            theFrame.pack();
            theFrame.setVisible(true);
        }
        in.close();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Appliances");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLocation(300,300);
        frame.setLayout(new GridLayout(1,3));

        JTextArea refrigerators = new JTextArea();
        refrigerators.setEditable(false);
        JTextArea dishwashers = new JTextArea();
        dishwashers.setEditable(false);
        JTextArea microwaves = new JTextArea();
        microwaves.setEditable(false);

        frame.pack();
        frame.setVisible(true);

        getSerialNumbers(frame, refrigerators, dishwashers, microwaves);
    }
    public static void main(String[] args) {
        createAndShowGUI();
    }
}