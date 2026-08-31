import java.io.*;
import java.util.*;
import java.lang.*;

public class Sol {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i-1) && !flag) {
                out.printf("YES%n%d %d", i, i+1);
                flag = true;
            }
        }
        if (!flag) out.println("NO");
        out.close();
    }
}