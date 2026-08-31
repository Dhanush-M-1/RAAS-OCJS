import java.util.*;
public class c201 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        int ans = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        while(n!= 0){
            int piv = sc.nextInt();
            if (k%piv == 0 & piv> ans)
                ans = piv;
            n = n-1;
        }
        System.out.println(k/ans);
    }
}
