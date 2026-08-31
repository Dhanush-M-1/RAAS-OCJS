import java.util.*;
import java.awt.*;
import java.io.*;
public class PhoneNumbers {
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        String str = f.readLine();
        int count = 0;
        for (int i=0; i<n; i++)
        {
            if (str.charAt(i)=='8')
            {
                count++;
            }
        }
        int ans = Math.min(n/11, count);
        System.out.println(ans);
    }
}
