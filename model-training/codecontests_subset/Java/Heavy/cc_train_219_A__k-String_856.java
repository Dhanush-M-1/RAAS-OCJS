import javax.print.attribute.HashAttributeSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Template
{
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static String readln() throws IOException
    {
        String line = input.readLine();
        return line;
    }

    public static void main(String[] args) throws IOException
    {
        solution();
    }


    public static void solution() throws IOException {
        int k = Integer.parseInt(readln());
        String s = readln();
        int n = s.length();
        int total = 0;
        char [] ch = s.toCharArray();
        Arrays.sort(ch);
        char c = ' ';
        s = new String(ch);
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                c = s.charAt(i);
            }
            if (s.charAt(i) == c ) {
                total++;
            }
        }
        StringBuilder sb = new StringBuilder("");
        if (n == total && total % k == 0) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j += k) {
                    sb.append(s.charAt(j));
                }
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("-1");
        }
    }
}

