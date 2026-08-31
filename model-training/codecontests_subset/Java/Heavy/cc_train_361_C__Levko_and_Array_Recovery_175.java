
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;


public class ProblemA {
    
    
    
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        int m = s.nextInt();
        
        int val[][] = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                val[i][j] = s.nextInt();
            }
        }
        
        
        long a[] = new long[n];
        Arrays.fill(a, 100000000);
        
        for (int i = m - 1; i >= 0; i--) {
            int l = val[i][1] - 1;
            int r = val[i][2] - 1;
            if(val[i][0] == 2){
                int max = val[i][3];
                
                for (int j = l; j <= r; j++) {
                    if(a[j] > max){
                        a[j] = max;
                    }
                }
            }
            else {
                int d = val[i][3];
                for (int j = l; j <= r; j++) {
                    a[j] -= d;
                }
            }
//          System.out.println(Arrays.toString(a));
        }
        
        long start[] = a.clone();
        for (int i = 0; i < m; i++) {
            if(val[i][0] == 1){
                for (int j = val[i][1] - 1; j <= val[i][2] - 1; j++) {
                    start[j] += val[i][3];
                }
            }
            else {
                long max = -Integer.MAX_VALUE;
                for (int j = val[i][1] - 1; j <= val[i][2] - 1; j++) {
                    max = Math.max(max, start[j]);
                }
                
                if(max != val[i][3]){
                    System.out.println("NO");
                    return ;
                }
            }
        }
        System.out.println("YES");
        for (int i = 0; i < start.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
//      int n = s.nextInt();
//      int k = s.nextInt();
//      
//      long a[] = new long[n];
//      for (int i = 0; i < n; i++) {
//          a[i] = s.nextLong();
//      }
//      if(n <= 0){
//          System.out.println("0");
//      }
//      
//      long left = 0;
//      long right = Integer.MAX_VALUE;
//      
//      while(left <= )
    }
    
}
