import java.io.*;
import java.util.*;

public class KString {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(f.readLine()); 
        String str = f.readLine();
        if (str.length() % k != 0)
        {
            System.out.println(-1);
            return;
        }
        char[] a = new char[str.length()];
        for (int i = 0; i < a.length; i++)
            a[i] = str.charAt(i);
        Arrays.sort(a);
        String s = "";
        for (int i = 0; i < str.length()/k; i++)
            if (a[k*i] == a[k*(i+1)-1])
                s += a[k*i];
            else
            {
                System.out.println(-1);
                return;
            }
        str = "";
        for (int i = 0; i < k; i++)
            str += s;
        System.out.println(str);
    }
}
