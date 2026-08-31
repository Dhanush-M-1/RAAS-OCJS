import java.util.*;
public class edu93_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.nextInt();
            int j = 0;
            int k = 1;
            int l = 2;
            while(l<n){
                if(arr[j]+arr[k] > arr[l])
                    l++;
                else{
                    System.out.printf("%d %d %d\n",j+1,k+1,l+1);
                    break;
                }
            }
            if(l == n)
                System.out.println("-1");
        }
    }
}