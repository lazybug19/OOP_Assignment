import java.io.*;
import java.util.*;

public class Sorter<E> {
    private E[] arr;
    private String type;

    public Sorter(E[] arr, String type) {
        this.arr = arr;
        this.type = type;
    }

    public void sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int size1 = mid - left + 1;
            int size2 = right - mid;
            sort(left, mid);
            sort(mid + 1, right);
            if (type.equals("String")) {
                String[] Left = new String[size1];
                String[] Right = new String[size2];
                mergeString(arr, left, mid, right, Left, Right);

            } else if (type.equals("Integer")) {
                Integer[] Left = new Integer[size1];
                Integer[] Right = new Integer[size2];
                mergeInt(arr, left, mid, right, Left, Right);
            } else if (type.equals("Double")) {
                Double[] Left = new Double[size1];
                Double[] Right = new Double[size2];
                mergeDouble(arr, left, mid, right, Left, Right);
            }
        }
    }

    public static int strComparator(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                return -1;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                return 1;
            }
        }
        if (str1.length() < str2.length()) {
            return -1;
        } else if (str1.length() > str2.length()) {
            return 1;
        } else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) < str2.charAt(i)) {
                    return -1;
                } else if (str1.charAt(i) > str2.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    public void mergeString(E[] arr, int left, int mid, int right, String[] Left, String[] Right) {
        int size1 = Left.length;
        int size2 = Right.length;

        for (int i = 0; i < size1; i++)
            Left[i] = (String) arr[left + i];

        for (int j = 0; j < size2; j++)
            Right[j] = (String) arr[mid + 1 + j];

        int start1 = 0; // Starting index of first subarray
        int start2 = 0; // Starting index of second subarray
        int start = left; // Starting index of merged subarray

        while (start1 < size1 && start2 < size2) {
            if (strComparator(Left[start1], Right[start2]) <= 0) {
                arr[start] = (E) Left[start1];
                start1++;
            } else {
                arr[start] = (E) Right[start2];
                start2++;
            }
            start++;
        }

        while (start1 < size1) {
            arr[start] = (E) Left[start1];
            start1++;
            start++;
        }

        while (start2 < size2) {
            arr[start] = (E) Right[start2];
            start2++;
            start++;
        }
    }

    @SuppressWarnings("unchecked")
    public void mergeInt(E[] arr, int left, int mid, int right, Integer[] Left, Integer[] Right) {
        int size1 = Left.length;
        int size2 = Right.length;

        for (int i = 0; i < size1; i++)
            Left[i] = (Integer) arr[left + i];

        for (int j = 0; j < size2; j++)
            Right[j] = (Integer) arr[mid + 1 + j];

        int start1 = 0; // Starting index of first subarray
        int start2 = 0; // Starting index of second subarray
        int start = left; // Starting index of merged subarray

        while (start1 < size1 && start2 < size2) {
            if (Left[start1] <= Right[start2]) {
                arr[start] = (E) Left[start1];
                start1++;
            } else {
                arr[start] = (E) Right[start2];
                start2++;
            }
            start++;
        }

        while (start1 < size1) {
            arr[start] = (E) Left[start1];
            start1++;
            start++;
        }

        while (start2 < size2) {
            arr[start] = (E) Right[start2];
            start2++;
            start++;
        }
    }

    @SuppressWarnings("unchecked")
    public void mergeDouble(E[] arr, int left, int mid, int right, Double[] Left, Double[] Right) {
        int size1 = Left.length;
        int size2 = Right.length;

        for (int i = 0; i < size1; i++)
            Left[i] = (Double) arr[left + i];

        for (int j = 0; j < size2; j++)
            Right[j] = (Double) arr[mid + 1 + j];

        int start1 = 0; // Starting index of first subarray
        int start2 = 0; // Starting index of second subarray
        int start = left; // Starting index of merged subarray

        while (start1 < size1 && start2 < size2) {
            if (Left[start1] <= Right[start2]) {
                arr[start] = (E) Left[start1];
                start1++;
            } else {
                arr[start] = (E) Right[start2];
                start2++;
            }
            start++;
        }

        while (start1 < size1) {
            arr[start] = (E) Left[start1];
            start1++;
            start++;
        }

        while (start2 < size2) {
            arr[start] = (E) Right[start2];
            start2++;
            start++;
        }
    }

    public void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            String dataType = scanner.next();

            if (dataType.equals("Integer")) {
                List<Integer> list = new ArrayList<>();
                while (scanner.hasNextInt()) {
                    int x = scanner.nextInt();
                    list.add(x);
                }
                Integer[] integers = new Integer[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    integers[i] = list.get(i);
                }
                Sorter<Integer> sorter = new Sorter<>(integers, dataType);
                sorter.sort(0, integers.length - 1);
                sorter.print();
            } else if (dataType.equals("Double")) {
                List<Double> list = new ArrayList<>();
                while (scanner.hasNextDouble()) {
                    Double x = scanner.nextDouble();
                    list.add(x);
                }
                Double[] doubles = new Double[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    doubles[i] = list.get(i);
                }
                Sorter<Double> sorter = new Sorter<>(doubles, dataType);
                sorter.sort(0, doubles.length - 1);
                sorter.print();
            } else if (dataType.equals("String")) {
                List<String> list = new ArrayList<>();
                while (scanner.hasNext()) {
                    String x = scanner.next();
                    list.add(x);
                }
                String[] strings = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    strings[i] = list.get(i);
                }
                Sorter<String> sorter = new Sorter<>(strings, dataType);
                sorter.sort(0, strings.length - 1);
                sorter.print();
            } else {
                System.out.println("Invalid data type specified.");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("java.io.FileNotFoundException: Error opening the specified file");
        } catch (NumberFormatException e) {
            System.out.println("java.lang.NumberFormatException: Error in string to number conversion");
        }
    }
}
