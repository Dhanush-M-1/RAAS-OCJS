
import java.util.*;

public class codeforce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int[]a = new int[n];
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
             a[i] = sc.nextInt();
            if (a[i]>max){
                max = a[i];
            }
            sum+=a[i];
        }
        boolean falg = true;
        while (falg){
            for (int i = 0; i < n; i++) {
                sum1+=max-a[i];
            }
            if(sum1>sum){
                System.out.println(max);
                falg = false;
            }else {
                sum1=0;
                max++;
            }
        }
        
        

    }
}
