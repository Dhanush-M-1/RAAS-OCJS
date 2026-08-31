import java.util.*;
import java.util.regex.*;
import java.lang.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int b = 0;
        
        for (int i = 0; i < n; i++) {
            b = sc.nextInt();
            for (int j = 0; j < b; j++) {
                hmap.put(sc.nextInt(), j);
            }
        }
        
        if (hmap.size() == m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
   
}