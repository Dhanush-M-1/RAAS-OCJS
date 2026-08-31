import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class PairProgramming {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }
            
            
            ArrayList<Integer> ans = new ArrayList<Integer>();
            boolean flag = true;
            int i = 0, j = 0;
            while(i < n || j < m){
                if(i < n && arr1[i] == 0){
                    ans.add(arr1[i]);
                    k = k+1;
                    i++;
                }
                else if(i < n && arr1[i] <= k){
                    ans.add(arr1[i]);
                    i++;
                }
                else if(j < m && arr2[j] == 0){
                    ans.add(arr2[j]);
                    k = k+1;
                    j++;
                }
                else if(j < m && arr2[j] <= k){
                    ans.add(arr2[j]);
                    j++;
                }
                else{
                    flag = false;
                    break;
                }
            }
            
            if(!flag){
                System.out.println(-1);
            }
            else{
                for (int x : ans) {
                    System.out.print(x+" ");
                }
                System.out.println();
            }
        }
    }
    
}