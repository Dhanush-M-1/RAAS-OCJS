import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E {

    long INF = Long.MAX_VALUE; // "Бесконечность"

    public static void main(String[] args) throws IOException {
        new E().run();
    }

    private void run() throws IOException {
        Reader in = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        solve(in, pw);
        pw.close();
    }

    static class Pair{
        long x,y;
        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        String next() throws IOException {
            while(st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    private void solve(Reader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> _11 = new ArrayList<>();
        ArrayList<Integer> _10 = new ArrayList<>();
        ArrayList<Integer> _01 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int t = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            if(a == 1 && b == 1) _11.add(t);
            else if(a == 0 && b == 1) _01.add(t);
            else if(a == 1 && b == 0) _10.add(t);
        }
        _11.sort(null);
        _01.sort(null);
        _10.sort(null);

        for(int i = 1; i < _11.size(); i++) _11.set(i, _11.get(i)+_11.get(i-1));
        for(int i = 1; i < _10.size(); i++) _10.set(i, _10.get(i)+_10.get(i-1));
        for(int i = 1; i < _01.size(); i++) _01.set(i, _01.get(i)+_01.get(i-1));

        if(_11.size() + Math.min(_01.size(), _10.size()) < k){
            out.println(-1);
            return;
        }

        int sum = 2000000001;
        int maxToAdd = Math.min(_01.size(), _10.size());
        if(maxToAdd >= k){
            sum = _01.get(k-1) + _10.get(k-1);
        }
        for(int cnt = 1; cnt <= _11.size(); cnt++){
            int toAdd = k - cnt;
            if(toAdd <= 0){
                sum = Math.min(sum, _11.get(cnt-1));
                continue;
            }
            if(toAdd > maxToAdd) continue;

            sum = Math.min(sum, _11.get(cnt-1) + _10.get(toAdd-1) + _01.get(toAdd-1));
        }

        out.println(sum);
    }
}


