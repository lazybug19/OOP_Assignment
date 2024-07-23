import java.util.Scanner;

public class Recursion {
    static int sum(int start, int end, int[] nums) {
        if (start == end)
            return nums[start];
        return nums[start] + sum(++start, end, nums);
    }

    static int multiply(int start, int end, int[] nums) {
        if (start == end)
            return nums[start];
        return nums[start] * multiply(++start, end, nums);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.print("Enter the array values: ");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter starting index: ");
        final int start = sc.nextInt();
        System.out.print("Enter ending index: ");
        final int end = sc.nextInt();
        if (start >= 0 && end < size) {
            System.out.print("Sum of elements from index " + start + " to " + end + " = ");
            System.out.println(sum(start, end, nums));
            System.out.print("Multiplication of elements from index " + start + " to " + end + " = ");
            System.out.println(multiply(start, end, nums));
        } else {
            System.exit(0);
        }
    }
}
