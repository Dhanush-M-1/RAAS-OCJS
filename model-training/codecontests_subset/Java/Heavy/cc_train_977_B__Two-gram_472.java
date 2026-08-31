import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoGram {
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
                catch (IOException  e)
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
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int count =0; 
        int max = 0 ;
        char[] x = sc.next().toCharArray();
        int index = 0;
        for ( int i = 0 ; i < n -1 ; i ++){
               count = 0 ;
            for (int j = 0 ; j <n-1 ; j ++){
                if (x[i]==x[j] && x[i+1]==x[j+1]){
                    count ++ ;
                }
                if (count > max){
                    max = count ;
                    index = i;
                }
            }
        }
        System.out.println(x[index]+""+x[index+1]);
    }
    
}
