import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        sc.nextLine();
        String word = sc.nextLine();
        HashMap<String, Integer> occurrences = new HashMap<>();

        String firstPair = word.charAt(0) + "";
        firstPair += word.charAt(1);
        occurrences.put(firstPair, 1);
        AbstractMap.SimpleEntry<String, Integer> max = new AbstractMap.SimpleEntry<>(firstPair, 1);
        for (int i = 1; i < length - 1; i++) {
            String ordered = word.charAt(i) + "";
            ordered += word.charAt(i + 1);
            if (!occurrences.containsKey(ordered)) {
                occurrences.put(ordered, 1);
                continue;
            }
            int found = occurrences.get(ordered) + 1;
            occurrences.put(ordered, found);
            if(found > max.getValue())
                max = new AbstractMap.SimpleEntry<>(ordered, found);

        }
        System.out.println(max.getKey());
    }
}