
import java.util.*;

public class RookBishopKing {

    public static int GCD(int a, int b){
        while (b!=0){
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    public static void main (String[] args)
    {       
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k= GCD(a,b);
        
        int nA = a/k;
        int nB = b/k;
        int res = 0;
    //    System.out.println(nA + " " + nB + " " + k );
        for (int i=2;i<=5;++i){
            while (nA%i==0){
                res++;
                nA/=i;
            }
        }
        for (int i=2;i<=5;++i){
            while (nB%i==0){
                res++;
                nB/=i;
            }
        }
      //  System.out.println(nA + " " + nB + " " + k );
        if (nA>1 || nB>1) System.out.println(-1);
        else System.out.println(res);
        sc.close();
    }
}