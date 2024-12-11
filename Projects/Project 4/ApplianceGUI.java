import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * The main GUI for displaying appliance information.
 */
public class ApplianceGUI extends JFrame {

    private TextArea refrigerators;
    private TextArea dishwashers;
    private TextArea microwaves;
    private FileMenuHandler fileMenuHandler;

    /**
     * Constructor for the GUI
     */
    public ApplianceGUI() {
        setTitle("Appliances");
        setSize(1200, 400);
        setLocation(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileMenuHandler = new FileMenuHandler(this);

        initializeMenu();
        initializeContentPane();
    }

    /**
     * Initialize the File menu
     */
    private void initializeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        // Create Open menu item
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileMenuHandler.openFile();
            }
        });

        // Create Quit menu item
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add items to the File menu and the menu bar
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);

        // Set the menu bar
        setJMenuBar(menuBar);
    }

    /**
     * Initialize content panes and text areas
     */
    public void initializeContentPane() {
        Container myContentPane = getContentPane();
        myContentPane.removeAll(); // Clear existing content
        refrigerators = new TextArea();
        dishwashers = new TextArea();
        microwaves = new TextArea();
        setLayout(new GridLayout(1, 3));

        myContentPane.add(refrigerators);
        myContentPane.add(dishwashers);
        myContentPane.add(microwaves);
        validate(); // Refresh the content pane
    }

    /**
     * Reads the serial document and updates the GUI.
     *
     * @param filePath the path of the file to be read
     */
    public void readSerialDoc(String filePath) {
        initializeContentPane(); // Clear and reset content for the new file

        // Comparator for sorting refrigerators
        Comparator<Refrigerator> fridgeComparator = new Comparator<Refrigerator>() {
            public int compare(Refrigerator r1, Refrigerator r2) {
                return Integer.compare(r1.getPrice(), r2.getPrice());
            }
        };

        // Comparator for sorting dishwashers
        Comparator<Dishwasher> dishwasherComparator = new Comparator<Dishwasher>() {
            public int compare(Dishwasher d1, Dishwasher d2) {
                return Integer.compare(d1.getPrice(), d2.getPrice());
            }
        };

        // Comparator for sorting microwaves
        Comparator<Microwave> microwaveComparator = new Comparator<Microwave>() {
            public int compare(Microwave m1, Microwave m2) {
                return Integer.compare(m1.getPrice(), m2.getPrice());
            }
        };

        // Created treemaps for each appliance
        TreeMap<Refrigerator, String> refrigeratorMap = new TreeMap<>(fridgeComparator);
        TreeMap<Dishwasher, String> dishwasherMap = new TreeMap<>(dishwasherComparator);
        TreeMap<Microwave, String> microwaveMap = new TreeMap<>(microwaveComparator);

        SortedApplianceList sortedList = new SortedApplianceList(); // Create the sorted list

        TextFileInput in = new TextFileInput(filePath);
        String line = in.readLine();
        while (line != null) {
            try {
                StringTokenizer tokens = new StringTokenizer(line, ",");
                if (tokens.hasMoreTokens()) {
                    String serialNum = tokens.nextToken().trim();
                    String type = serialNum.substring(0, 1); // type of appliance based on the first character

                    if (!isValid(serialNum)) {
                        throw new IllegalApplianceException("Invalid serial number: " + serialNum);
                    }

                    int price;
                    Appliance appliance = null;
                    if (type.equals("R")) {
                        price = Integer.parseInt(tokens.nextToken().trim());
                        int cubicFeet = Integer.parseInt(tokens.nextToken().trim());
                        appliance = new Refrigerator(serialNum, price, cubicFeet);
                        refrigeratorMap.put((Refrigerator) appliance, appliance.toString());
                    } else if (type.equals("D")) {
                        price = Integer.parseInt(tokens.nextToken().trim());
                        boolean undercounter = Boolean.parseBoolean(tokens.nextToken().trim());
                        appliance = new Dishwasher(serialNum, price, undercounter);
                        dishwasherMap.put((Dishwasher) appliance, appliance.toString());
                    } else if (type.equals("M")) {
                        price = Integer.parseInt(tokens.nextToken().trim());
                        int watts = Integer.parseInt(tokens.nextToken().trim());
                        appliance = new Microwave(serialNum, price, watts);
                        microwaveMap.put((Microwave) appliance, appliance.toString());
                    }

                    if (appliance != null) {
                        sortedList.add(appliance); // Add appliance to the sorted list depending on first character
                    }
                }
            } catch (IllegalApplianceException e) {
                System.out.println(e.getMessage());
            } finally {
                line = in.readLine();
            }
        }
        in.close();

        // Adds sorted appliances to the GUI
        for (String applianceDetails : refrigeratorMap.values()) {
            refrigerators.append(applianceDetails + "\n");
        }
        for (String applianceDetails : dishwasherMap.values()) {
            dishwashers.append(applianceDetails + "\n");
        }
        for (String applianceDetails : microwaveMap.values()) {
            microwaves.append(applianceDetails + "\n");
        }

        setVisible(true); // Refresh the GUI
    }

    /**
     * Print the serial GUI
     *
     * @param appGUI the instance of ApplianceGUI to be used
     */
    public void printSerialGUI(ApplianceGUI appGUI) {
        appGUI.initializeContentPane();
        appGUI.readSerialDoc("p3input.txt");
    }

    /**
     * Validates the serial number
     *
     * @param psn the serial number to validate
     * @return true if the serial number is valid, false otherwise
     */
    public boolean isValid(String psn) {
        if (psn.length() != 12) {
            return false;
        }

        char firstCharacter = psn.charAt(0);
        if (!(firstCharacter == 'R' || firstCharacter == 'D' || firstCharacter == 'M')) {
            return false;
        }

        for (int i = 1; i < psn.length(); i++) {
            char c = psn.charAt(i);
            if (!(Character.isUpperCase(c) || Character.isDigit(c))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Getter for refrigerators text area
     *
     * @return the TextArea for refrigerators
     */
    public TextArea getRefrigerators() {
        return refrigerators;
    }

    /**
     * Getter for dishwashers text area
     *
     * @return the TextArea for dishwashers
     */
    public TextArea getDishwashers() {
        return dishwashers;
    }

    /**
     * Getter for microwaves text area
     *
     * @return the TextArea for microwaves
     */
    public TextArea getMicrowaves() {
        return microwaves;
    }
}
