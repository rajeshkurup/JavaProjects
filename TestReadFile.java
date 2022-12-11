import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {

    public static void main(String[] args) {

        Scanner fileScanner = loadInputFile();
        if(fileScanner != null) {
            int[] inputData = readInputFile(fileScanner);
            if(inputData != null) {
                int[] outputData = numberOfOccurences(inputData);
                if(outputData != null) {
                    printHistogram(outputData);
                    printSummary(inputData, outputData);
                }
            }
        }

    }

    public static void printSummary(int[] inputData, int[] outputData) {
        System.out.println("Total Elements = " + inputData.length);
        double average = findAverage(inputData);
        System.out.println("Average = " + average);
        int maxIdx = maxElement(outputData);
        System.out.println("Mode = " + maxIdx);
    }

    public static void printHistogram(int[] outputData) {
        for(int i = 0; i < outputData.length; i++) {
            String stars = "";
            for(int j = 0; j < outputData[i]; j++) {
                stars += "*";
            }
            System.out.println(i + "| " + stars);
        }
    }

    public static double findAverage(int[] intArr) {
        double average = 0;
        for(int i = 0; i < intArr.length; i++) {
            average += intArr[i];
        }

        if(intArr.length > 0) {
            average /= intArr.length;
        }

        return average;
    }

    /**
     * Input Array
     * [0] 12
     * [1] 12
     * [2] 14
     * [3] 16
     * [4] 16
     * [5] 16
     * [6] 18
     * [7] 18
     * [8] 20
     * 
     * Output Array
     * [0] 0
     * [1] 0
     * [2] 0
     * [3] 0
     * [4] 0
     * [5] 0
     * [6] 0
     * [7] 0
     * [8] 0
     * [9] 0
     * [10] 0
     * [11] 0
     * [12] 2
     * [13] 0
     * [14] 1
     * [15] 0
     * [16] 3
     * [17] 0
     * [18] 2
     * [19] 0
     * [20] 1
     */

    public static int[] numberOfOccurences(int[] intArr) {
        int[] result = null;

        int idxMaxElem = maxElement(intArr);
        if(idxMaxElem > -1) {
            int sizeOfOutputArr = intArr[idxMaxElem] + 1;
            result = new int[sizeOfOutputArr];
            for(int i = 0; i < intArr.length; i++) {
                int idxOfResult = intArr[i];
                result[idxOfResult] += 1;
            }
        }

        return result;
    }


    public static int maxElement(int[] intArr) {
        int result = -1;
        int maxValue = -1;
        for(int i = 0; i < intArr.length; i++) {
            if(maxValue < intArr[i]) {
                maxValue = intArr[i];
                result = i;
            }
        }

        return result;
    }

    public static Scanner loadInputFile() {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("./test_int_data.txt"));
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return fileScanner;
    }

    public static int[] readInputFile(Scanner fileScanner) {
        int[] inputData = null;

        if(fileScanner.hasNextLine()) {
            int totalEntries = fileScanner.nextInt();
            if(totalEntries > 0) {
                inputData = new int[totalEntries];
                int counter = 0;
                while(fileScanner.hasNextLine() && counter < totalEntries) {
                    inputData[counter] = fileScanner.nextInt();
                    counter++;
                }
            }
        }

        return inputData;
    }

}