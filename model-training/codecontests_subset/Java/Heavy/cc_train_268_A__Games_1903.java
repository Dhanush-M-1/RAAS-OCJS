import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Map<Integer,Integer> mapAway = new HashMap<>();
        int [] home = new int [n];
        for (int i = 0; i < n; i++) {
            home[i]=s.nextInt();
            int away = s.nextInt();
            if (mapAway.containsKey(away)){
                mapAway.put(away, mapAway.get(away)+1);
            }else{
                mapAway.put(away,1);
            }
        }
        int result = 0;
        for (int i = 0; i < home.length; i++) {
            if (mapAway.containsKey(home[i])){
                result+=mapAway.get(home[i]);
            }
        }
        System.out.println(result);
    }
}
