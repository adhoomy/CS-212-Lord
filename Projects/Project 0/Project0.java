// import this so we can show input and message dialogs
import javax.swing.JOptionPane;

public class Project0 {
    public static void main(String[] args) {
        // program will continue as long as go is true, this is an infinite while loop
        boolean go = true;
        while(go == true) {
            // initialize a string called sentence where the input will be stored
            String sentence;
            sentence = JOptionPane.showInputDialog("Type a sentence:");

            // typing "stop" will exit the program (not case sensitive)
            if(sentence.equalsIgnoreCase("Stop")) {
                System.exit(0);
            }

            // initialize two int variables to store the count of uppercase and lowercase e(s)
            int uppercaseE = 0;
            int lowercaseE = 0;

            // in a for loop we start at the beginning index and end at the last index (length of the sentence), don't include "=" because we start at 0
            for(int i=0; i<sentence.length(); i++) {
                // store the character in the index in a char
                char character = sentence.charAt(i);

                // if the char equals 'E', we add 1 to the count of uppercase E
                if(character=='E') {
                    uppercaseE++;
                }
                // if the char equals 'e', we add 1 to the count of lowercase E
                if(character=='e') {
                    lowercaseE++;
                }
            }

            // after we go through each char in the sentence, we print the counts of uppercase and lowercase e(s) in the pop up message
            JOptionPane.showMessageDialog(null, "Number of lowercase e's: " + lowercaseE + "\nNumber of uppercase e's: " + uppercaseE);
        }
    }
}