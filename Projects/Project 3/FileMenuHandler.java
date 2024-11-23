import javax.swing.*;
import java.io.File;

/**
 * Handles file menu operations.
 */
public class FileMenuHandler {

    private ApplianceGUI gui;

    /**
     * Constructor for FileMenuHandler.
     *
     * @param gui the instance of ApplianceGUI that this handler will interact with
     */
    public FileMenuHandler(ApplianceGUI gui) {
        this.gui = gui;
    }

    /**
     * Method to handle file opening.
     */
    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int fileSelection = fileChooser.showOpenDialog(gui);

        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            gui.readSerialDoc(selectedFile.getAbsolutePath());
        }
    }
}
