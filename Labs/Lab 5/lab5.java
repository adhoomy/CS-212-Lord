package lab5;

import javax.swing.JOptionPane;

public class lab5 {
    public static void main(String[] args) {
        TextFileInput in = new TextFileInput("words.txt");
        int filled = 0;
        String line = in.readLine();
		String[] wordArray = new String[10];
        while(filled <= wordArray.length && line != null) {
            wordArray[filled++] = line;
            line = in.readLine();
        }

		String isOrIsNot, inputWord;
			
		// This line asks the user for input by popping out a single window
		// with text input
        boolean go = true;
        while(go == true) {
		    inputWord = JOptionPane.showInputDialog(null, "Enter a word in all lower case:");
		
		    // if the inputWord is contained within wordArray return true
		    if (wordIsThere(inputWord, wordArray))
		    	isOrIsNot = "is"; // set to is if the word is on the list
		    else
		    	isOrIsNot = "is not"; // set to is not if the word is not on the list

		    // Output to a JOptionPane window whether the word is on the list or not
		    JOptionPane.showMessageDialog(null, "The word " + inputWord + " " + isOrIsNot + " on the list.");
        }
	} //main

	public static boolean wordIsThere(String findMe, String[] theList) {
        if(findMe.equals("STOP")) {
            System.exit(0);
        }
        for(int i=0; i < theList.length; i++) {
            if(findMe.equals(theList[i])) {
                return true;
            }
        }
        return false;
	}
}
