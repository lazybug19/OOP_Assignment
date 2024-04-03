package Q4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        scanner.close();
        Solution solution = new Solution();
        int result = solution.divide(nums, k);
        System.out.println(result);
    }
}

class Solution {
    public int countSplit(int[] nums, int mid) {
        int count = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((sum + nums[i]) <= mid)
                sum += nums[i];
            else {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }

    public int divide(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min)
                min = nums[i];
            max += nums[i];
        }
        while (min <= max) {
            // implementing binary search algorith
            int mid = (min + max) / 2;
            int count = countSplit(nums, mid);
            if (count > k)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }
}