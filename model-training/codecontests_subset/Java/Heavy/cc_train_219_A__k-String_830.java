import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException { 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            PrintWriter out = new PrintWriter(System.out);
            int[] f = new int[26];
            int n  = Integer.parseInt(br.readLine());
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++)
                f[s.charAt(i)-'a']++;
            StringBuilder sb = new StringBuilder();
            boolean fail = false;
                for (int k = 0; k < n; k++) {
            for (int i = 0; i < 26; i++) {
                if (f[i] == 0)
                    continue;
                    if (f[i] % n == 0) 
                        for (int j = 0; j < f[i]/n; j++)
                            sb.append((char)(i+'a'));
                    else {
                        fail = true;
                        break;
                    }
                }
            }
            out.println(fail ? "-1" : sb.toString());
            out.flush();
            out.close();
        }
    }
}

