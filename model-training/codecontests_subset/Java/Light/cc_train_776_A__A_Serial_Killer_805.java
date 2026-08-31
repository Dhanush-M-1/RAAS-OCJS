
import java.util.*;

public class index {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
	
    String s1 = sc.next();
    String s2 = sc.next();
    
    int t = sc.nextInt();
   	
    
    while(t-- > 0)
    {
       System.out.println(s1+" "+s2);
      	String s3 = sc.next();
      	String s4 = sc.next();
      
      if(s3.equals(s1)){
        s1 = new String(s4);
      }
      else
      {
        s2 = new String(s4);
      }
    }
    System.out.println(s1 + " " + s2);
    
  }
}
