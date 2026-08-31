

import java.io.IOException;
import java.util.Scanner;

public class codeforces {
	
	public static void main(String[] args) throws IOException {

	  Scanner in = new Scanner(System.in);
      int n= in.nextInt();
      int x=in.nextInt();
      int y = in.nextInt();
      String s = in.next();
      //System.out.println(s);
      int i=0;
     
      int k= n-(x+1);
      String s1 = s.substring(n-k, n);
      //System.out.println(s1);
      long sum = (long)Math.pow(10, y);
      int p=0;
      for(i=0;i<x;i++)
      {
    	  if(i==y && s.charAt(n-i-1)=='0')
    	  {
    		  p++;
    	  }
    	  
    	  if(i!=y && s.charAt(n-i-1)=='1')
    	  {
    		  p++;
    	  }
      }
      System.out.println(p);
   
}


}
	




	 
