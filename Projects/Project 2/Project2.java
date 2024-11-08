import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class Project2 {

    // method for adding creating appliance objects and adds them to the arrays
    private static void readSerialDoc(TextArea fridges, TextArea washers, TextArea waves) {

        SortedApplianceList sortedList = new SortedApplianceList();  // Create the sorted list

        // Read appliances from the file and add them to the sorted list
        TextFileInput in = new TextFileInput("p2input.txt");
        String line = in.readLine();
        while (line != null) {
            StringTokenizer tokens = new StringTokenizer(line, ",");
            if (tokens.hasMoreTokens()) {
                String serialNum = tokens.nextToken().trim();
                String type = serialNum.substring(0, 1);  // type of appliance based on the first character

                int price;
                Appliance appliance = null;
                if(type.equals("R")) {
                    price = Integer.parseInt(tokens.nextToken().trim());
                    int cubicFeet = Integer.parseInt(tokens.nextToken().trim());
                    appliance = new Refrigerator(serialNum, price, cubicFeet);
                }
                else if(type.equals("D")) {
                    price = Integer.parseInt(tokens.nextToken().trim());
                    boolean undercounter = Boolean.parseBoolean(tokens.nextToken().trim());
                    appliance = new Dishwasher(serialNum, price, undercounter);
                }
                else if(type.equals("M")) {
                    price = Integer.parseInt(tokens.nextToken().trim());
                    int watts = Integer.parseInt(tokens.nextToken().trim());
                    appliance = new Microwave(serialNum, price, watts);
                }

                if (appliance != null) {
                    sortedList.add(appliance);  // Add appliance to the sorted list depending on first character
                }
            }
            line = in.readLine();
        }
        in.close();

        // goes through sorted linked list and adds it to the gui
        ApplianceNode current = sortedList.first.next;
        while(current != null) {
            String sNum = current.data.serialNumber.substring(0, 1);;
            if(sNum.equals("R")) {
                fridges.append(current.data.toString() + "\n");
            }
            if(sNum.equals("D")) {
                washers.append(current.data.toString() + "\n");
            }
            if(sNum.equals("M")) {
                waves.append(current.data.toString() + "\n");
            }
            current = current.next;
        }

    }

    public static void main(String[] args) {
        // creates gui and adds the serial numbers sorted
        ApplianceGUI gui = new ApplianceGUI();
        gui.printSerialGUI(gui);
    }

    public static class ApplianceGUI extends JFrame {
        // creates the constructor for the gui
        public ApplianceGUI() {
            setTitle("Appliances");
            setSize(1200, 400);
            setLocation(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        // creates the content pane and text areas where the organized sorted serial numbers will be displayed
        public static void printSerialGUI(ApplianceGUI appGUI) {
            Container myContentPane = appGUI.getContentPane();
            TextArea refrigerators = new TextArea();
            TextArea dishwashers = new TextArea();
            TextArea microwaves = new TextArea();
            appGUI.setLayout(new GridLayout(1, 3));

            // calls method to create the appliance objects with the serial numbers and add them to the text areas
            readSerialDoc(refrigerators, dishwashers, microwaves);

            // adds the content pane and text areas to the jframe and makes it visible
            myContentPane.add(refrigerators);
            myContentPane.add(dishwashers);
            myContentPane.add(microwaves);
            appGUI.setVisible(true);
        }
    }
}
