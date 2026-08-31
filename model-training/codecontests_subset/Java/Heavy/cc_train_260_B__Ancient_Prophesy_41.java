import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static void zap() throws IOException {
        String str = br.readLine();
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        HashMap<String, Integer> my = new HashMap<String, Integer>();
        for(int i=0;i<=str.length()-10;i++)
        {
            String now = str.substring(i, i+10);
            if(now.charAt(2) != '-' || now.charAt(5) != '-')
                continue;
            int flag = 1;
            for(int j=0;j<now.length();j++)
                if(j != 2 && j != 5)
                    if(now.charAt(j) < '0' || now.charAt(j) > '9')
                    {
                        flag = 0;
                        break;
                    }
            if(flag == 0)
                continue;
            int dd = Integer.parseInt(now.substring(0,0+2));
            int mm = Integer.parseInt(now.substring(3,3+2));
            int yy = Integer.parseInt(now.substring(6,6+4));
            if(yy > 2015 || yy < 2013)
                continue;
            if(mm > 12 || mm < 1)
                continue;
            if(dd < 1 || dd > days[mm-1])
                continue;
            if(my.containsKey(now))
                my.put(now, my.get(now)+1);
            else
                my.put(now, 1);
        }
        int maxs = -1;
        String apocalypse = "";
        for(Map.Entry<String, Integer> entry : my.entrySet())
        {
            if(entry.getValue() > maxs)
            {
                maxs = entry.getValue();
                apocalypse = entry.getKey();
            }
        }
        out.println(apocalypse);
    }

    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        //InputStream input = new FileInputStream("fileIn.in");
        br = new BufferedReader(new InputStreamReader(input));
        out = new PrintWriter(System.out);
        //out = new PrintWriter(new FileOutputStream("fileOut.out"));
        zap();
        out.close();
    }

    static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }
}