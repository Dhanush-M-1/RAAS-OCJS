import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1382A {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            int m = input.nextInt();
            int[] arr = new int[n];
            int[] arr2 = new int[m];

            boolean[] visited = new boolean[1000+1];

            for(int i = 0;i < n;i++){
                arr[i] = input.nextInt();
                visited[arr[i]] = true;
            }
            boolean found = false;
            int ans = -1;

            for(int i = 0;i < m;i++){
                arr2[i] = input.nextInt();
                if(visited[arr2[i]] && !found){
                    found = true;
                    ans = arr2[i];
                }
            }
            
            if(found){
                pw.println("YES");
                pw.println(1 + " " + ans);
            }
            else{
                pw.println("NO");
            }
            t--;
        }


        // ****If sorting is required, use ArrayList
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
