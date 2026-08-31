import java.util.*;

public class Solution {

	
	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
       sc.nextLine();
      String s=sc.nextLine();
      int l=s.length();
      char a=s.charAt(0);
      int ind=-1;
      for(int i=1;i<l;i++) {
    	  char b=s.charAt(i);
    	  if(b>=a) {
    		  a=b;
    		  continue;
    	  }
    	  ind=i;
    	  break;
    		  
    	  
      }
     if(ind==-1)
    	 System.out.println("NO");
     else {
    	 System.out.println("YES");
    	 System.out.println((ind)+" "+(ind+1));
     }
	}
    
}