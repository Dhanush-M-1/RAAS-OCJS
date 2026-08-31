import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String s = sc.next();
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        System.out.println("AC x " + map.getOrDefault("AC",0));
        System.out.println("WA x " + map.getOrDefault("WA",0));
        System.out.println("TLE x " + map.getOrDefault("TLE",0));
        System.out.println("RE x " + map.getOrDefault("RE",0));
    }
}