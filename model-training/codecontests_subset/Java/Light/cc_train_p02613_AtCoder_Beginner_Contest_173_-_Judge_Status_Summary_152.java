import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String testCase = input.next();
            map.put(testCase, map.getOrDefault(testCase, 0) + 1);
        }
        System.out.println("AC x " + map.getOrDefault("AC", 0));
        System.out.println("WA x " + map.getOrDefault("WA", 0));
        System.out.println("TLE x " + map.getOrDefault("TLE", 0));
        System.out.println("RE x " + map.getOrDefault("RE", 0));
    }
}