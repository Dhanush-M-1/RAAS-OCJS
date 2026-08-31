import java.io.PrintWriter;
import java.util.*;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    final long mod = 1000000000+7;
    public static void main(String[] args) {
        Main main = new Main();
//        main.solve();
//        out.flush();
        System.out.println(main.solve());
    }
    // segment tree to record minimum value
    // Each point has a infinite distance from 0 (except itself)
    long solve() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); int k = sc.nextInt();
        LinkedList<Integer> s = new LinkedList<>();
        for(char c:str.toCharArray()){
            s.add(c-'0');
        }
        long ans = helper(s,k);
        return ans;
    }
    long helper(LinkedList<Integer> s, int k){
        if(k==0){
            return 1;
        }
        while(s.size()>0&&s.peek()==0) s.poll();
        int len = s.size();
        if(len<k) return 0;
        long ans = 0;
        for(int size=k;size<len;size++){
            long cur = comb(size-1,k-1)*power(9,k);
            ans += cur;
        }
        // then consider the highest digit
        ans += (s.get(0)-1)*comb(len-1,k-1)*power(9,k-1);
        //then the highest take the value of current head
        s.poll();
        ans += helper(s,k-1);
        return ans;
    }
    long power(long base, long p){
        long ans = 1;
        while(p>0){
            if(p%2==1) ans = ans*base%mod;
            base = base*base%mod;
            p /= 2;
        }
        return ans;
    }
    // compute nCm
    long comb(int n, int m){
        if(n<m) return 0;
        if(m==0) return 1;
        long ans = 1;
        for(int j=0;j<m;j++) ans *= n-j;
        while(m>0){
            ans /= m;
             m--;
        }
        return ans;
    }
}

