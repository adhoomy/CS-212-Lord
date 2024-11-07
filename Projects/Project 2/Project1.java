import javax.swing.*;
import java.awt.*;

public class Project1 {

    // method for adding creating appliance objects and adds them to the arrays
    private static void readSerialDoc(TextArea fridges, TextArea washers, TextArea waves) {
        Appliance[] appliances = new Appliance[100];
        Appliance[] fridgeArray = new Appliance[20];
        Appliance[] washArray = new Appliance[20];
        Appliance[] waveArray = new Appliance[20];

        // to count the number of appliances stored in each
        int applianceNum = 0, fridgeNum = 0, washerNum = 0, waveNum = 0;

        // reads file and turns serial numbers into object appliances, then stored in array for all appliances and array for specific appliance
        TextFileInput in = new TextFileInput("data.txt");
        String line = in.readLine();
        while (line != null && applianceNum < appliances.length) {
            appliances[applianceNum] = new Appliance(line);
            if (appliances[applianceNum].toString().equals("refrigerator")) {
                fridgeArray[fridgeNum++] = appliances[applianceNum];
            }
            if (appliances[applianceNum].toString().equals("dishwasher")) {
                washArray[washerNum++] = appliances[applianceNum];
            }
            if (appliances[applianceNum].toString().equals("microwave")) {
                waveArray[waveNum++] = appliances[applianceNum];
            }
            applianceNum++;
            line = in.readLine();
        }
        in.close();
        
        // sorts each category
        selectionSort(fridgeArray, fridgeNum);
        selectionSort(washArray, washerNum);
        selectionSort(waveArray, waveNum);

        // add sorted appliances to text areas
        addTextArea(fridgeArray, fridgeNum, fridges);
        addTextArea(washArray, washerNum, washers);
        addTextArea(waveArray, waveNum, waves);
    }

    // selection sort method to order serial numbers for each column
    public static void selectionSort(Appliance[] appliances, int count) {
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (appliances[j].compareTo(appliances[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // swap the appliances
            Appliance temp = appliances[i];
            appliances[i] = appliances[minIndex];
            appliances[minIndex] = temp;
        }
    }

    // sorts the appliances to the text areas
    public static void addTextArea(Appliance[] appliances, int count, TextArea textArea) {
        for (int i = 0; i < count; i++) {
            textArea.append(appliances[i].getSerialNumber() + "\n");
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
            setSize(500, 400);
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
