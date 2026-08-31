import  java.util.*;
public class Main {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

         while (t-- > 0) {
             int ans;
             char[] chars = in.next().toCharArray();
             ans = 0;

             for (int i = 1; i < chars.length; i++) {
                 if (chars[i-1] == chars[i] && chars[i] != '0') {
                     chars[i] = '0';
                     ans++;
                 }
                 int a = i+1;
                 if (a < chars.length && chars[i-1] == chars[a] && chars[a] != '0') {
                     chars[a] = '0';
                     ans++;
                 }
             }
             System.out.println(ans);

         }
    }
}