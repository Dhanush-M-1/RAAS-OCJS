import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        map.put("AC", 0);
        map.put("WA", 0);
        map.put("TLE", 0);
        map.put("RE", 0);

        for(int i=0; i<n; i++){
            String s = sc.next();
            map.put(s, map.get(s) + 1);
        }

        System.out.println("AC x " + map.get("AC") + "\nWA x " + map.get("WA") +"\nTLE x " + map.get("TLE") + "\nRE x " + map.get("RE"));
    }
}