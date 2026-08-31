import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(),x = 0;
        Map<String,Integer> map = new LinkedHashMap<>();
        String[] items = {"AC","WA","TLE","RE"};
        for (String s: items) map.put(s,0);
        for (int i = 0; i < a; i++) {
            String ans = sc.next();
            map.put(ans,map.get(ans)+1);
        }
        for(int n:map.values()) System.out.println(items[x++] + " x " + n);
    }
}
