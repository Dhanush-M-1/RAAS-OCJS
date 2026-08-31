import java.util.*;
public class Solution {
      public static void main(String[] args) {
    	  Scanner ip=new Scanner(System.in);
    	  int n=ip.nextInt();
    	  long a1[]=new long[n];
    	  long sum1=0;
    	  for(int i=0;i<n;i++) {
    		  a1[i]=ip.nextLong();
    		  sum1+=a1[i];
    	  }
    	  long sum2=0;
    	  long a2[]=new long[n-1];
    	  for(int i=0;i<n-1;i++) {
    		  a2[i]=ip.nextLong();
    		  sum2+=a2[i];
    	  }
    	  long sum3=0;
    	  long a3[]=new long[n-2];
    	  for(int i=0;i<n-2;i++) {
              a3[i]=ip.nextLong();
              sum3+=a3[i];
    	  }
    	 
    	  System.out.println(sum1-sum2);
    	  System.out.println(sum2-sum3);
    	  
      }
}
