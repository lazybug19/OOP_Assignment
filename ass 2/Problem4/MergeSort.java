import java.io.*;
import java.util.*;

public class MergeSort {
    private int[] array;
    private int[] tempArray;

    MergeSort(int[] inputArray) {
        this.array = inputArray;
        this.tempArray = new int[inputArray.length];
        mergeSort(0, inputArray.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int midl = (left + right) / 2;
            Thread lThread = new Thread(() -> mergeSort(left, midl));
            Thread rThread = new Thread(() -> mergeSort(midl + 1, right));
            lThread.start();
            rThread.start();

            try {
                lThread.join();
                rThread.join();
                merge(left, midl, right);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void merge(int left, int midl, int right) {
        for (int i = left; i <= right; i++) {
            tempArray[i] = array[i];
        }

        int lowIndex = left;
        int highIndex = midl + 1;
        int current = left;

        while (lowIndex <= midl && highIndex <= right) {
            if (tempArray[lowIndex] > tempArray[highIndex]) {
                array[current] = tempArray[highIndex];
                highIndex++;
            } else {
                array[current] = tempArray[lowIndex];
                lowIndex++;
            }
            current++;
        }
        while (lowIndex <= midl) {
            array[current] = tempArray[lowIndex];
            lowIndex++;
            current++;
        }
        while (highIndex <= right) {
            array[current] = tempArray[highIndex];
            highIndex++;
            current++;
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(args[0]);
            Scanner input = new Scanner(file);
            int size = 0;
            while (input.hasNextInt()) {
                size++;
                numbers.add(input.nextInt());
            }
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = numbers.get(i);
            }
            input.close();
            MergeSort soRter = new MergeSort(array);
            for (Integer i = 0; i < size; i++) {
                System.out.print(array[i]);
                if (i < size - 1) {
                    System.out.print(" ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("java.io.FileNotFoundException: Error opening the specified file");
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException: Error in string to number conversion");

        }
    }
}
