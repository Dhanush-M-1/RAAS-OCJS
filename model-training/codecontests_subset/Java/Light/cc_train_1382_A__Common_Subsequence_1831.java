import java.util.*;
// scanner.nextInt();
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test_case = scanner.nextInt();
        
        for(int i = 0; i < test_case; ++i)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            int[] arrn = new int[n];
            int[] arrm = new int[m];
            for(int j = 0; j < n; ++j)
            {
                arrn[j] = scanner.nextInt();
            }
            for(int j = 0; j < m; ++j)
            {
                arrm[j] = scanner.nextInt();
            }
            
            boolean res = false;
            
            for(int j = 0; j < n; ++j)
            {
                for(int k = 0; k < m; ++k)
                {
                    if(arrn[j] == arrm[k])
                    {
                        res = true;
                        System.out.println("YES");
                        System.out.println(1 + " " + arrn[j]);
                        break;
                    }                  
                }
                if(res) break;
            }
            if(!res) System.out.println("NO");
        }
    }
}