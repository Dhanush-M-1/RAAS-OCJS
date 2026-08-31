import java.util.*;
 
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i= 0; i<n; i++){
                a[i] = sc.nextInt();
            }
            if(n<3) {
                System.out.println("-1");
                return;
            }
            int i = 0;
            int j = i+1;
            int k = n-1;
            if(a[i]+a[j]<=a[k])
                System.out.println((i+1)+" "+(j+1)+" "+(k+1));
            else
                System.out.println("-1");
        }
    }
}