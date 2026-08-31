import java.util.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    static final int MOD = (int)1e9+7;
    
    public static void main(String[] args){
        
        int t = Integer.parseInt(sc.next());
        for(int i=0; i<t; i++){
            solve();
        }
    }
    
    public static void solve(){
        int n = Integer.parseInt(sc.next());
        long sum = 0;
        PriorityQueue<Long> left = new PriorityQueue<>();
        PriorityQueue<Long> right = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            long k = Integer.parseInt(sc.next());
            int l = Integer.parseInt(sc.next());
            int r = Integer.parseInt(sc.next());
            sum += Math.min(l, r);
            if(l < r){
                right.add(((n-k)<<32) + r-l);
            }else{
                left.add((k<<32) + l-r);
            }
        }
        
        sum += ureshisa(left) + ureshisa(right);
        System.out.println(sum);
        
    }
    
    public static long ureshisa(PriorityQueue<Long> q){
        int size = q.size();
        PriorityQueue<Integer> ok = new PriorityQueue<>();
        for(int i=0; i<size; i++){
            long x = q.poll();
            int k = (int)(x>>32);
            int dif = (int)x;
            ok.add(dif);
            while(ok.size() > k){
                ok.poll();
            }
        }
        long res = 0;
        for(int tmp : ok){
            res += tmp;
        }
        return res;
    }
}
