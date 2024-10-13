import javax.swing.JOptionPane;

public class lab6 {
    public static void main(String[] args) {
        TextFileInput in = new TextFileInput("numbers.txt");
        int filled = 0;
        String line = in.readLine();
		int[] wordArray = new int[20];
        while(filled <= wordArray.length && line != null) {
            wordArray[filled++] = Integer.parseInt(line);
            line = in.readLine();
        }
		
        int fileSum = sum(wordArray, filled);
        JOptionPane.showMessageDialog(null, "The sum of the integers in the file is: " + fileSum);

        int fileAve = average(fileSum, filled);
        JOptionPane.showMessageDialog(null, "The average of the integers in the file is: " + fileAve);
		
    } //main

    public static int sum(int[] myArray, int myArraySize) {
        int theSum = 0;
        for(int i=0; i<=myArraySize; i++) {
            theSum+=myArray[i];
        }
        return theSum;
    }

    public static int average(int sameSum, int myArraySize) {
        return sameSum/myArraySize;
    }

}
