import java.util.*;
import java.lang.*;
import java.io.*;

public class R4 {
    public static void main(String[] Args){
        FastReader scan=new FastReader();
        int n=scan.nextInt();
        node[] arr=new node[n+1];
        for (int i = 1; i <=n ; i++) {
            arr[i]=new node(i+1);
        }
        for(int i=0;i<n-1;i++){
            int u=scan.nextInt();
            int v=scan.nextInt();
            arr[u].neighs.add(v);
            arr[v].neighs.add(u);
        }
        for (int i = 1; i <=n ; i++) {
            if(arr[i].neighs.size()==2){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static class node{
        int v;
        ArrayList<Integer> neighs;
        node(int v){
            this.v=v;
            neighs=new ArrayList<>();
        }
    }
    static class FastReader {
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

}
