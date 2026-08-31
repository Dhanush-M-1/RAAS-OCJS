import java.util.*;
import java.io.*;

public class TwoGram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length() - 1; i++){
            String x = s.substring(i, i + 2);
            if(map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);
        }

        int max = Integer.MIN_VALUE;
        String ans = "";
        for(String x : map.keySet()) {
            if(map.get(x) > max){
                max = map.get(x);
                ans = x;
            }
        }

        System.out.println(ans);
    }
}
