import java.io.*;
import java.util.*;

public class F {
    public static long[] min;
    public static long[] t;
    public static void push(int v){
        t[v*2] += t[v];
        t[v*2+1] += t[v];
        t[v] = 0;
    }
    public static int find(int v, int vl, int vr){
        if(vl == vr - 1){
            return v;
        }
        push(v);
        min[v] = Math.min(get_val(v * 2), get_val(v * 2 + 1));
        if(get_val(v * 2 + 1) == 0){
            return find(v * 2 + 1, (vl + vr) / 2, vr);
        }
        else{
            return find(v*2, vl, (vl+vr)/2);
        }
    }
    public static void add(int v, int vl, int vr, int ql, int qr, int x){
        if(ql <= vl && qr >= vr){
            t[v] += x;
            return;
        }
        else if(qr <= vl || ql >= vr){
            return;
        }
        add(v*2, vl, (vl+vr)/2, ql, qr,x);
        add(v*2+1, (vl+vr)/2, vr, ql, qr,x);
        min[v] = Math.min(get_val(v*2), get_val(v*2+1));
    }
    public static long get_val(int v){
        long start = min[v];
        return Math.max(start - t[v], 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        long[] array = new long[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; ++i){
            array[i] = Long.parseLong(st.nextToken());
        }
        int new_n = n;
        int counter = 0;
        while(new_n > 0){
            new_n /= 2;
            ++counter;
        }
        new_n = 1 << counter;
        min = new long[new_n * 2];
        t = new long[new_n * 2];
        for(int i = 0; i < min.length; ++i){
            min[i] = Long.MAX_VALUE;
        }
        int[] ans = new int[n];
        int now = 1;
        for(int i = new_n; i < new_n + n; ++i){
            min[i] = array[i - new_n];
        }
        for(int i = new_n - 1; i >= 0; --i){
            min[i] = Math.min(min[i * 2], min[i * 2 + 1]);
        }
        for(int i = 1; i <= n; ++i){
            int node = find(1, 0, new_n) - new_n;
            ans[node] = now;
            min[node + new_n] = Long.MAX_VALUE;
            int ver = node + new_n;
            while(ver != 1){
                ver/= 2;
                min[ver] = Math.min(get_val(ver * 2), get_val(ver * 2 + 1));
            }
            add(1, 0, new_n, node, new_n, now);
            ++now;
        }
        for(int i = 0; i < n; ++i){
            writer.print(ans[i] + " ");
        }
        writer.close();
    }
}