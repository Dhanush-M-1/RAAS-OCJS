import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String s = scan.next();
        int i = 0;
        int j = 1;

        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        String res = "";
        while(j<N) {
            String current = "";
            current += chars[i];
            current += chars[j];

            map.put(current, map.getOrDefault(current, 0) + 1);
            if(max < map.get(current)) {
                max = map.get(current);
                res = current;
            }
            i++;
            j++;
        }
        System.out.println(res);        
        scan.close();
    }
}