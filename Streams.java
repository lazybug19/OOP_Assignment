import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        List<String> strings = Arrays.asList("null", "null", "null", " ", "", "null", "null", "null", "null", "null");
        random.ints(10, 1, 20).sorted().forEach(x -> list.add(x));
        List<Integer> mapped = list.stream().map(x -> x + 2).distinct().collect(Collectors.toList());
        List<String> filtered = strings.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(filtered);
        System.out.println(mapped);
    }
}