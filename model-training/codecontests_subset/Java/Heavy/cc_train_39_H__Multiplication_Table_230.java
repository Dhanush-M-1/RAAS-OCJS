import java.util.*;
// scanner.nextInt();
public class Solution {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

            

                int n = scanner.nextInt();
                
                int[][] array = new int[n-2][n-2];
                
                for(int i = 0; i < array.length; ++i)
                {
                    for(int j = 0; j < array.length; ++j)
                    {
                        array[i][j] = (i+2)*(j+2);
                    }
                }
                
                String res = "1";
                for(int i = 1; i < n-1; ++i)
                {
                    res += " " + (i+1);
                }
                System.out.println(res);
                
                if(n > 2)
                {
                    for(int i = 0; i < n-2; ++i)
                    {
                    res = String.valueOf(i+2);
                    for(int j = 0; j < array[i].length; ++j) res += " " + Integer.toString(array[i][j],n);
                        System.out.println(res);
                    }
                }
                /*

                for(int i = 0; i < n; ++i)
                    {
                        array[i] = scanner.nextInt();
                    }
                 */
                //String[] arr = {"aa","bb","c", "d","ee", "ff" , "gg" , "hh", "ii" , "jj" , "k" , "l", "m", "n", "o", "p", "q" , "r", "s", "t", "u" , "v", "w" ,"x", "y", "z"};
 
            
                    
    }
}

