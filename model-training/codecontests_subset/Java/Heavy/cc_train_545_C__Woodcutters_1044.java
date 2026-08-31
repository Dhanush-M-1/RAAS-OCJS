import java.util.*;
import java.io.*;

public class Main {
    // For fast input output
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setErr(new PrintStream(new FileOutputStream("error.txt")));
                System.setOut(out);
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    // end of fast i/o code
    static StringBuilder str = new StringBuilder("");
    static int dp[];

    // static int solve(int i, int n, int val, ArrayList<Integer> spots, ArrayList<Integer> heights)
    // {
    //     if(i==n)
    //         return val;
    //     if((spots.get(i)-spots.get(i-1))>heights.get(i))
    //     {
    //         System.err.println(i+" fell on left.");
    //         return solve(i+1,n,val+1,spots,heights);
    //     }
    //     else if((spots.get(i)-spots.get(i-1))<=heights.get(i) && 
    //                 (spots.get(i)-spots.get(i+1))<=heights.get(i))
    //     {
    //         System.err.println(i+" did not fall");
    //         return solve(i+1,n,val,spots,heights);
    //     }
    //     else 
    //     {
    //         System.err.println("contending for right");
    //         int a = solve(i+1,n,val,spots,heights);
    //         spots.set(i, spots.get(i)+heights.get(i));
    //         int b = solve(i+1,n,val+1,spots,heights);
    //         spots.set(i, spots.get(i)-heights.get(i));
    //         return Math.max(a, b);
    //     }
        
    // }
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        if(n==1)
        {
            System.out.println(1);
            return;
        }
        ArrayList<Integer> spots = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            spots.add(reader.nextInt());
            heights.add(reader.nextInt());
        }
        int count = 2; 
        for(int i=1; i<n-1; i++)
        {
            if((spots.get(i)-spots.get(i-1))>heights.get(i))
                count++;
            else if((spots.get(i+1)-spots.get(i))>heights.get(i))
            {
                spots.set(i, spots.get(i)+heights.get(i));
                count++;
            }
        }
        System.out.println(count);
    }
}