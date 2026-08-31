import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long fact = 1;
        long pow = 1;
        
        for(int i=2; i<n+1; i++){
            fact = (fact*i)%1000000007;
            pow = pow*2%1000000007;
        }
        
        System.out.println((fact-pow+1000000007)%1000000007);
    }
}