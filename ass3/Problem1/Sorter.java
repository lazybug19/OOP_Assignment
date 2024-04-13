import java.io.*;
import java.util.*;

class StringCompare implements CompareInterface<String> {
    @Override
    public int compare(String a, String b) {
        int result = a.compareToIgnoreCase(b); // Ignore case (upper/lower) and sort
        if (result == 0) {
            return a.compareTo(b); // If strings equal, we compare ASCII values
        }
        return result;
    }
}

class IntCompare implements CompareInterface<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

class DoubleCompare implements CompareInterface<Double> {
    @Override
    public int compare(Double a, Double b) {
        return Double.compare(a, b);
    }
}

interface CompareInterface<T> {
    int compare(T a, T b);
}

public class Sorter<T> {

    private T[] array;

    public Sorter(T[] array) {
        this.array = array;
    }

    public void sort(CompareInterface<T> comparator) {
        mergeSort(array, comparator);
    }

    private void mergeSort(T[] arr, CompareInterface<T> comparator) {
        if (arr.length <= 1) {
            return;
        }

        T[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        T[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(arr, left, right, comparator);
    }

    private void merge(T[] result, T[] left, T[] right, CompareInterface<T> comparator) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (comparator.compare(left[i], right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString().trim()); // Trim each element before printing
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Sorter <input_filename>");
            return;
        }

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            String dataType = scanner.nextLine().trim();

            switch (dataType) {
                case "Integer":
                    List<Integer> intList = new ArrayList<>();
                    while (scanner.hasNextInt()) {
                        intList.add(scanner.nextInt());
                    }
                    Integer[] intArray = intList.toArray(new Integer[0]);
                    Sorter<Integer> intSorter = new Sorter<>(intArray);
                    intSorter.sort(new IntCompare());
                    intSorter.print();
                    break;
                case "Double":
                    List<Double> doubleList = new ArrayList<>();
                    while (scanner.hasNextDouble()) {
                        doubleList.add(scanner.nextDouble());
                    }
                    Double[] doubleArray = doubleList.toArray(new Double[0]);
                    Sorter<Double> doubleSorter = new Sorter<>(doubleArray);
                    doubleSorter.sort(new DoubleCompare());
                    doubleSorter.print();
                    break;
                case "String":
                    List<String> stringList = new ArrayList<>();
                    while (scanner.hasNext()) {
                        stringList.add(scanner.next());
                    }
                    String[] stringArray = stringList.toArray(new String[0]);
                    Sorter<String> stringSorter = new Sorter<>(stringArray);
                    stringSorter.sort(new StringCompare());
                    stringSorter.print();
                    break;
                default:
                    System.out.println("Invalid data type specified in the input file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }
}