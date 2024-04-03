package Q1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Take input for integer array nums
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // size of array
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        // Create an instance of BubbleSort and perform sorting
        Sortable bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        printArray(nums);

        // Create an instance of SelectionSort and perform sorting
        Sortable selectionSort = new SelectionSort();
        selectionSort.sort(nums);
        printArray(nums);
    }

    // Method to print the elements of an array
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

interface Sortable {
    public void sort(int[] nums);
}

class BubbleSort implements Sortable {
    public void sort(int[] nums) {
        int size = nums.length;
        boolean noFurtherSwaps;
        for (int start = size - 1; start >= 0; start--) {
            noFurtherSwaps = false;
            for (int end = 0; end <= start - 1; end++) {
                if (nums[end] > nums[end + 1]) {
                    // swapping array elements so that smaller values move to front
                    int intermediate = nums[end];
                    nums[end] = nums[end + 1];
                    nums[end + 1] = intermediate;
                    noFurtherSwaps = true;
                }
            }
            // to avoid unecessary swaps in already sorted array
            if (noFurtherSwaps == false)
                break;
        }
    }
}

class SelectionSort implements Sortable {
    public void sort(int[] nums) {
        int left = 0, right = 0, index, size = nums.length;
        for (; left < size - 1; left++) {
            right = left + 1;
            index = left;
            for (; right < size; right++) {
                if (nums[index] > nums[right])
                    index = right;
            }
            // swapping array elements so that smaller values move to front
            int intermediate = nums[index];
            nums[index] = nums[left];
            nums[left] = intermediate;
        }
    }
}
