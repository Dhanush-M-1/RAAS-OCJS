/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    static int MOD=(int)1e9+7;
	public static void main(String[] args) {
	    
	    Scanner sc=new Scanner(System.in);
	    
	    int n=sc.nextInt();
	    
	    if (n == 1 || n == 2) {
	        
            System.out.println(0);
            
            return;
        }
        long answer = 1, tt = 2, x;
        
        for (long i = 1; i <= n; i++) {
            
            answer *= i;
            answer %= MOD;
            
        }
        
        for (long i = 1; i < n - 1; i++) {
            
            tt *= 2;
            tt %= MOD;
        }
        
        answer -= tt;
        answer += MOD;
        answer %= MOD;
        System.out.println(answer);
	}
}