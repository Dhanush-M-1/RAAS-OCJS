import org.omg.CORBA.MARSHAL;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer>[]ts = new TreeSet[n];
        for (int i =0;i<n;i++)ts[i]=new TreeSet<>();
        ArrayList<Integer>size= new ArrayList<>();
        while (m-->0){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            ts[Math.min(x,y)].add(Math.max(x,y));
        }
        int[]vals = new int[n];
        Arrays.fill(vals,1);
        w:for (int i =0;i<n;i++){
            for (int j =i+1;j<n;j++)
                if (!ts[i].contains(j)){
                   vals[j]+=vals[i];
                   TreeSet<Integer>nxt = new TreeSet<>();
                   for (int x:ts[i])
                       if (ts[j].contains(x))
                           nxt.add(x);
                   ts[j]=nxt;
                   continue w;

            }
            size.add(vals[i]);
        }
        Collections.sort(size);
        pw.println(size.size());
        for (int x:size)
            pw.print(x+" ");
        pw.println();
        pw.close();

    }
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(next());
            }
            return arr;
        }

    }

}