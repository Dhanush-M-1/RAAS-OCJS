import java.util.*;
import java.math.*;

public class sdf{

  public static void main(String[] args)  {

      	Scanner in = new Scanner(System.in);

      	int n = in.nextInt();
      	String s = in.next();

      	boolean increas = true;
      	for(int i = 0; i < n - 1; i++)
      		if(s.charAt(i) > s.charAt(i+1)){
      			increas = false;
      			break;
      		}

      	if(increas){
      		System.out.println("NO");
      		System.exit(0);
      	}
      	
      	int start = 0;
      	int subLen = 2;
      	for(int i = 0; i < n - 1; i++)
      		if(s.charAt(i) > s.charAt(i+1)){
			
			start = i + 1;
      		int j = start;
      		while(s.charAt(i) < s.charAt(j)){
      			j++;
      			subLen++;
      		}

      		break;

      	}


      	System.out.println("YES");
      	System.out.println( start + " " + (start+subLen-1) );



      		



      }}   
