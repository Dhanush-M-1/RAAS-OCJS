import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x, i, j=3, ans = 0, ex = 0;
        for(i = 0; i < n; i++){
            x = sc.nextInt();
            //System.out.print(x);
            ex=0;
            if(x==2)ans++;
            else if(x>2&&x%2!=0){
                for(j=2; j<=Math.sqrt(x) ;j++){
                    if(x%j==0)ex++;
                }
                if(ex==0)ans++;
            }
            //System.out.println(" "+ans);
        }
        System.out.println(ans);
    }
}
