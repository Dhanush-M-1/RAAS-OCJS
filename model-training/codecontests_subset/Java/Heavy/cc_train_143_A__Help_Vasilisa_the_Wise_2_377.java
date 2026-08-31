import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CF143A {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int r1 = input.nextInt();
        int r2 = input.nextInt();

        int c1 = input.nextInt();
        int c2 = input.nextInt();

        int d1 = input.nextInt();
        int d2 = input.nextInt();

       int a = -1;
       int b = -1;
       int c = -1;
       int d = -1;

       boolean con = false;
        for(int i = 1;i <= 9;i++){
            for(int j = 1;j <= 9;j++){
                for(int k = 1;k <= 9;k++){
                    for(int l = 1;l <= 9;l++){
                        if((i+j) == r1 && (k+l) == r2 && (i+k) == c1 && (j+l) == c2 && (i+l) == d1 && (j+k) == d2){
                            a = i;
                            b = j;
                            c = k;
                            d = l;
                            con = true;
                            break;
                        }
                    }
                    if(con)
                        break;
                }
                if(con)
                    break;
            }
            if(con)
                break;
        }
        Set<Integer> set = new HashSet<Integer>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        if(!con || set.size() < 4){
            pw.println(-1);
        }
        else{
            pw.println(a + " " + b);
            pw.println(c + " " + d);
        }


        pw.flush();
        pw.close();
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
