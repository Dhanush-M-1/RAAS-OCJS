import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Letter {

    //Way 1
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     int n = sc.nextInt();
//     int k = sc.nextInt();
//     int[] a = new int[n];
//     for(int i=0; i<n; i++)
//         a[i] = sc.nextInt();
//     int count = 0, ans=-1;
//     for(int i=0; i<n; i++){
//         count += (i+1);
//         if(count >= k){
//             ans = a[i-(count-k)];
//             break;
//         }
//     }
//     System.out.println(ans);
//     sc.close();
//   }

    //Way 2
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++)
            a[i] = sc.nextInt();
        int i=1;
        while(i<k){
            k -= i;
            i++;
        }
        System.out.println(a[k-1]);
        sc.close();
        }
}
