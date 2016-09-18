package csula.cs4660.exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Introduction Java exercise to read file
 */
public class FileRead {
    private int[][] numbers;
    private static final int ROWS = 5;
    private static final int COLUMNS = 8;
    /**
     * Read the file and store the content to 2d array of int
     * @param file read file
     */
    public FileRead(File file) {
        numbers = new int[ROWS][COLUMNS];
        try{
            FileReader fr = new FileReader(file);
            BufferedReader buffer = new BufferedReader(fr);

            String line = null;
            int row = 0;
            while((line = buffer.readLine()) != null){
                String[] values = line.split(" ");
                for (int i = 0; i < values.length; i++) {
                    numbers[row][i] = Integer.parseInt(values[i]);
                }
                row++;
            }
        }
        catch (Exception e){
            System.err.println("you fukked it");
        }
    }

    /**
     * Read the file assuming following by the format of split by space and next
     * line. Display the sum for each line and tell me
     * which line has the highest mean.
     *
     * lineNumber starts with 0 (programming friendly!)
     */
    public int mean(int lineNumber) {
        //System.out.println("****MEAN****");
        int sum = 0;
        int count = 0;
        for (int i = 0; i < COLUMNS; i++) {
            sum += numbers[lineNumber][i];
            count++;
            //System.out.println("sum: " + sum);
            //System.out.println("count: " + count);
        }
        int mean = sum / count;
        return mean;
    }

    public int max(int lineNumber) {
        //System.out.println("****MAX****");
        int max = 0;
        for (int i = 0; i < COLUMNS; i++) {
            if (numbers[lineNumber][i] > max){
                max = numbers[lineNumber][i];
            }
        }
        return max;
    }

    public int min(int lineNumber) {
        int min = 1000;
        for (int i = 0; i < COLUMNS; i++) {
            if (numbers[lineNumber][i] < min){
                min = numbers[lineNumber][i];
            }
        }
        return min;
    }

    public int sum(int lineNumber) {
        int sum = 0;
        for (int i = 0; i < COLUMNS; i++) {
            sum += numbers[lineNumber][i];
        }
        return sum;
    }
}
