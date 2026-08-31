import java.io.*;
import java.util.*;
import java.lang.*;

public class Practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int i;
        int j = 0;
        for (i = 0; i < n - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                j = i + 1;
                break;
            }
        }
        if (i == n - 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            j++;
            System.out.println(i + 1 + " " + j);
        }
    }
}