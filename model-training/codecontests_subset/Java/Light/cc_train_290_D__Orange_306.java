import java.util.Scanner;

// http://codeforces.com/contest/290/problem/D
public class Orange {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().toLowerCase();
        int a = s.nextInt();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 'a' + a) {
                ans += Character.toUpperCase(str.charAt(i));
            } else {
                ans += str.charAt(i);
            }
        }
        System.out.println(ans);
        s.close();
    }

}
