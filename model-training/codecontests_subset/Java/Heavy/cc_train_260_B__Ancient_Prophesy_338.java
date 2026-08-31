import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
 
    static final double eps = 1e-8;
    static int mod = 1000 * 1000 * 1000 + 9;
    
    static int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
    
    static HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public static void main(String[] args) throws IOException {
        try {
            String s = bf.readLine();
            int max = 0;
            String maxString = "!!";
            for(int i = 0; i + 10 <= s.length(); i++)
            {
                if(s.charAt(i + 2) != '-' || s.charAt(i + 5) != '-')
                    continue;
                int day, mounth, year;
                try
                {
                    day = Integer.parseInt(s.substring(i, i + 2));
                    mounth = Integer.parseInt(s.substring(i + 3, i + 5));
                    year = Integer.parseInt(s.substring(i + 6, i + 10));
                }
                catch(NumberFormatException e) {
                    continue;
                }
                if(mounth > 0 && mounth < 13 && day > 0 && day <= m[mounth - 1] && year > 2012 && year < 2016)
                    if(map.containsKey(s.substring(i, i + 10)))
                    {
                        int t = map.get(s.substring(i, i + 10)) + 1;
                        map.put(s.substring(i, i + 10), t);
                        if(t > max)
                        {
                            max = t;
                            maxString = s.substring(i, i + 10);
                        }
                    }
                    else
                    {
                        if(max == 0)
                        {
                            max = 1;
                            maxString = s.substring(i, i + 10);
                        }
                        map.put(s.substring(i, i + 10), 1);
                    }
            }
            pw.println(maxString);
            
        }
        finally {
            
            pw.close();
        }
    }


     
     
    

    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }
    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
    static void outArray(int[] O) {
        for(int i = 0; i < O.length - 1; i++)
            pw.print(O[i] + " ");
        pw.println(O[O.length - 1]);
    }
    static void exit(Object arg)
    {
        pw.println(arg);
        pw.flush();
        System.exit(0);
    }
}