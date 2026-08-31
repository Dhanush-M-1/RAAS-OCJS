
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q= sc.nextInt();
        int[]a = sc.nextIntArr(n);
        int[]b=a.clone();
        Arrays.sort(b);
        int ans =(int)2e9;
        for (int j=0;j<n;j++){
            PriorityQueue<Integer>pq = new PriorityQueue<>(),all= new PriorityQueue<>();
            for (int i =0;i<n;i++){
                if (a[i]<b[j])
                {
                    while (pq.size()>=k){
                        all.add(pq.poll());
                    }
                    pq.clear();
                }
                else pq.add(a[i]);
            }
            while (pq.size()>=k){
                all.add(pq.poll());
            }
            int c=q;
            if (all.size()<q)
                break;
            while (c-->1)all.poll();
            if (!all.isEmpty())
            ans=Math.min(ans,(all.poll()-b[j]));
        }
        pw.println(Math.max(ans,0));
        pw.flush();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
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

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = nextInt();
            return arr;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}