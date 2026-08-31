import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main {

    
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine().trim());
        int t = 1;
        while (t-- > 0) {
            String[] lines = br.readLine().trim().split(" ");
            int n = Integer.parseInt(lines[0]);
            int x = Integer.parseInt(lines[1]);
            int y = Integer.parseInt(lines[2]);
            String s = br.readLine().trim();
            char[] ch = new char[x];
            Arrays.fill(ch, '0');
            ch[x-y-1] = '1';
            int res = 0;
            int index = 0;
            for (int i=n-x; i<n; i++) {
                if (ch[index++]!=s.charAt(i)) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    
}