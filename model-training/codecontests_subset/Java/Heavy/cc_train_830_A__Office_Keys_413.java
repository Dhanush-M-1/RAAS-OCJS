import java.util.*;
import java.io.*;

import static java.lang.System.in;

public class Main {
    static int n,k,p;
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String[] buf = reader.readLine().split(" ");
        n = Integer.parseInt(buf[0]); k = Integer.parseInt(buf[1]); p = Integer.parseInt(buf[2]);
        int[] a = new int[n],b=new int[k];
        buf = reader.readLine().split(" ");
        long lo=0,hi=2000000000;
        for(int i=0;i<n;i++) a[i]=Integer.parseInt(buf[i]);
        buf = reader.readLine().split(" ");
        for(int i=0;i<k;i++) b[i]=Integer.parseInt(buf[i]);
        Arrays.sort(a);
        lo = Math.max(Math.abs(a[0]-p),Math.abs(a[n-1]-p));
        while(hi>lo){
            long mid = (hi+lo)/2;
            if(check(a,b,mid)) hi=mid;
            else lo=mid+1;
        }
        System.out.println(lo);
    }
    static boolean check(int[] a, int[] b, long mid){
        TreeSet<Integer> ts = new TreeSet<>();
        for(int w:b) ts.add(w);
        for(int cur:a){
            boolean flag = false;
            while(!flag&&ts.size()>0){
                Integer key = ts.pollFirst();
                if(Math.abs(cur-key)+Math.abs(key-p)<=mid) flag = true;
            }
            if(!flag) return false;
        }
        return true;
    }
}
