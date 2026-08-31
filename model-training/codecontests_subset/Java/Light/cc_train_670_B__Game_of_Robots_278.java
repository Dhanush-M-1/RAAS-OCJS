//package practic;
import java.util.*;

public class Practic{
    public static void main(String[] args){
        Scanner in = new Scanner (System.in);
        
        int n = in.nextInt(), k = in.nextInt(), m = 1;
        int a[] = new int[100001];
        
        for (int i = 1; i <= n; i++)
            a[i] = in.nextInt();
        
        for (int i = 1; i <= n; i++){
            if (k - m <= 0){
                System.out.println(a[k]);
                break;
            }
            
            k -= m;
            m++;
        }
    }
}