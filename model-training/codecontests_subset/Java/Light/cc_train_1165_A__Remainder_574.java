import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
 
public class A {
 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String ip = in.nextLine();
        String s = in.nextLine();
 
        String[] ips = ip.split(" ");
        int n = Integer.parseInt(ips[0]);
        int x = Integer.parseInt(ips[1]);
        int y = Integer.parseInt(ips[2]);
 
        int ans = 0;
        for (int i = n - x; i < n; ++i) {
            if (i == n - y - 1) {
                ans = s.charAt(i) == '1' ? ans : ans + 1;
            } else {
                if (s.charAt(i) != '0') ++ans;
            }
        }
        out.println(ans);
 
    }
}