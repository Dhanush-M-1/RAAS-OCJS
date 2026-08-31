import java.util.*;
import java.io.*;
public class codeforces {
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
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

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);PrintWriter pw = new PrintWriter(System.out);
        int n=sc.nextInt();int m=sc.nextInt();int k=sc.nextInt();
        int[] arr = new int[n+1];Arrays.fill(arr,0);for (int i=0;i<m;i++) arr[sc.nextInt()]=-1;
        int[] cost = new int[k];for (int i=0;i<k;i++) cost[i]=sc.nextInt();
        if (arr[0]==-1){System.out.print(-1);return;}long ans=-1;
        for (int i=0;i<=n;i++){ if (arr[i]!=-1) arr[i]=i;else arr[i]=arr[i-1]; }boolean st=false;
        for (int p=1;p<=k;p++){
            int id=0;int t=0;boolean pos=true;
            while (id<n){
                if (id-arr[id]>=p) {pos=false;break;}
                id=arr[id];id+=p;t++;
            }
            long s = (long)cost[p-1]*t;
            if (pos&&!st) {ans=s;st=true;}
            else if (pos) ans=Math.min(ans,s);
        }
        System.out.print(ans);
    }
}