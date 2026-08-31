import java.math.BigInteger;
import java.sql.Statement;
import java.util.HashSet;
import java.util.*;

public class Solution{

   public int solve(int a , int b){
       int counter1[] =  new int[3];
       int counter2[] = new int[3];

       while (a%2 == 0) {
           counter1[0]++;
           a/=2;
       }
       while (a%3 == 0) {
           counter1[1]++;
           a/=3;
       }
       while (a%5 == 0) {
           counter1[2]++;
           a/= 5;
       }
       

       while (b%2 == 0) {
           counter2[0]++;
           b/=2;
       }
       while (b%3 == 0) {
           counter2[1]++;
           b/=3;
       }
       while (b%5 == 0) {
           counter2[2]++;
           b/=5;
       }
       if(a!= b)
           return -1;
       

        int ans = 0;
       for(int i=0 ; i<3 ; i++)
           ans+= Math.abs(counter1[i] - counter2[i]);
   return ans;
   }
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner input = new Scanner(System.in);
        System.out.println(s.solve(input.nextInt(),input.nextInt()));
    }
}
