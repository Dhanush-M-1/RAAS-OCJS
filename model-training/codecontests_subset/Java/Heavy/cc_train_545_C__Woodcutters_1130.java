import java.util.*;
import java.lang.StringBuilder;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long xs[] = new long[n];
        long hs[] = new long[n];
        int fallen[] = new int[n];

        for(int i=0;i<n;i++){
            xs[i] = scanner.nextLong();
            hs[i] = scanner.nextLong();
            fallen[i] = 0;
        }
        fallen[0] = -1;
        fallen[n - 1] = 1;
        for(int i=1;i<n-1;i++){
            if((fallen[i-1] <= 0 && xs[i] - hs[i] > xs[i-1]) || (fallen[i-1] == 1 && xs[i] - hs[i] > xs[i-1] + hs[i-1])){
                fallen[i] = -1;
            }
            else if(xs[i] + hs[i] < xs[i+1]){
                fallen[i] = 1;
            }
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            ans+=Math.abs(fallen[i]);
        }
        System.out.println(ans);
    }
}