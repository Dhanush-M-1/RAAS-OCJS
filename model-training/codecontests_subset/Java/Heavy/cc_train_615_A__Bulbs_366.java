import java.io.*;
import java.util.*;
public class Practice 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        boolean[] bulbs = new boolean[m + 1];
        
        for(int i = 0; i < n; i++)
        {
            s = reader.readLine().split(" ");
            for(int j = 1; j < s.length; j++) bulbs[Integer.parseInt(s[j])] = true;
        }
        
        boolean yes = true;
        for(int i = 1; i < bulbs.length; i++) if(!bulbs[i]) yes = false;
        
        if(yes) System.out.println("YES");
        else System.out.println("NO");
    }
}
