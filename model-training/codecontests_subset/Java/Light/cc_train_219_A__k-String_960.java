import java.io.PrintWriter;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int k = sc.nextInt();
        sc.nextLine();
        char[] arr = sc.nextLine().toCharArray();
        boolean flag = true;
        TreeMap<Character, Integer> dd = new TreeMap<>();
        for (char c : arr) dd.put(c, dd.getOrDefault(c, 0) + 1);
        for (int x : dd.values()) {
            if (x % k != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            StringBuilder ans = new StringBuilder();
            for(char c: dd.keySet()){
                for(int i = 0; i<dd.get(c) / k; i++){
                    ans.append(c);
                }
            }
            StringBuilder last = new StringBuilder();
            for(int i=0; i < k; i++){
                last.append(ans);
            }
            System.out.println(last);

        }else{
            System.out.println(-1);
        }

    }
}