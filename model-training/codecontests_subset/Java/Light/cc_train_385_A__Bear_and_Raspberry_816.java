import java.util.*;

public class A_Bear_and_Raspberry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, c,ans = 0,max = 0;
        n = in.nextInt();
        c = in.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
           ans = a[i]-a[i+1]-c;
           if(ans>max){
               max = ans;
           }
        }
        System.out.println(max);
    }

}
