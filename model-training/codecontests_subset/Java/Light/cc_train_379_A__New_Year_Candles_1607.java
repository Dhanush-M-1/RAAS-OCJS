import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution{
   
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
       int a = sc.nextInt();
       int b = sc.nextInt();
      int count = a;
        while(a >= b) {
            int rem = a % b;
            a /= b;
            count += a;
            a += rem;
        }
        System.out.println(count);
    }
}