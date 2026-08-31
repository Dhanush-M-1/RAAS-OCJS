import java.util.*;
import java.math.*;

public class Problem {
    static long div=-1;
    static HashMap<Long,Boolean> memo = new HashMap<Long, Boolean>();
    
    static boolean win(long Q) {
        Boolean res = memo.get(Q);
        if(res!=null) return res;
        //System.out.println("win "+Q);
        boolean puedeDividir=false;
        for(long i=2; i*i<=Q; i++) {
            if(Q%i==0) {
                puedeDividir=true;
                if(!win(i)) {
                    div=i;
                    memo.put(Q,true);
                    return true;
                }
                else if(!win(Q/i)) {
                    div=Q/i;
                    memo.put(Q,true);
                    return true;
                }
            }
        }
        
        memo.put(Q, !puedeDividir);
        return !puedeDividir;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long Q = input.nextLong();
        boolean w=win(Q);
        
        if(w) {
            System.out.println(1);
            System.out.println(div==-1?0:div);
        }
        else
            System.out.println(2);
    }
    
}
