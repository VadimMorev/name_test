import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        String string = "aa bbb c aa bb aa cc bbb cc";
        String[] arr = string.split(" ");
        List<String> frequency = new ArrayList<>(Arrays.asList(arr));
        Map<String, Long> wordCount = frequency.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
        wordCount.entrySet().forEach(e -> System.out.println(e));

    }
}