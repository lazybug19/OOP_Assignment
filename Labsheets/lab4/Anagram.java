import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public boolean areAnagrams(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        return false;
    }

    class StringUtil {
        public String sortString(String str) {
            char[] Array = new char[str.length()];
            for (int i = 0; i < str.length(); i++) {
                Array[i] = str.charAt(i);
            }
            Arrays.sort(Array);
            String sortStr = "";
            for (char c : Array) {
                sortStr = sortStr + c;
            }
            return sortStr;
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        Anagram anagram = new Anagram();
        Anagram.StringUtil util = anagram.new StringUtil();
        System.out.print("Enter the first string : ");
        String str1 = sc.nextLine();
        str1 = util.sortString(str1);
        System.out.print("Enter the second string : ");
        String str2 = sc.nextLine();
        str2 = util.sortString(str2);
        if (anagram.areAnagrams(str1, str2)) {
            System.out.println("The entered strings are anagrams.");
        } else {
            System.out.println("Not anagrams.");
        }
    }
}
