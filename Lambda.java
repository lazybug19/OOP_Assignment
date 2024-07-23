import java.util.*;

interface StringFilter {
    List<String> filter(List<String> strings, int minLength);
}

public class Lambda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            String s = sc.next(); // not nextLine()
            strings.add(s);
        }
        int len = sc.nextInt();
        StringFilter stringFilter = (list, length) -> {
            List<String> filtered = new ArrayList<>();
            for (String s : list) {
                if (s.length() >= length) {
                    filtered.add(s);
                }
            }
            return filtered;
        };
        sc.close();
        System.out.println(stringFilter.filter(strings, len));
    }
}
