import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0; i<M; i++){
            a.add(scanner.nextInt());
        }
        Set<Integer> bloken = new HashSet<>(a);
        List<Integer> w = new ArrayList<>();
        w.add(1);
        if(bloken.contains(1)){
            w.add(0);
        }else{
            w.add(1);
        }
        
        for(int i=2; i<=N; i++){
            if(bloken.contains(i)){
                w.add(0);
            }else{
                w.add( (w.get(i-1) + w.get(i-2))%1000000007 );
            }
        }
        
        //System.out.println(w);
        System.out.println(w.get(N)%1000000007);
    }
}