import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import javax.lang.model.type.NullType;

public class ProblemSolving {
	static Scanner s=new Scanner(System.in);
	
	public int GetMax(List arr) {
		int maxValue = (int) arr.get(0); 
	    for(int i=1;i < arr.size();i++){ 
	      if((int)arr.get(i) > maxValue){ 
	         maxValue = (int)arr.get(i); 
	      } 
	    } 
	    return maxValue; 
	
	}

	public int GetMin(List arr) {
		int minValue =(int) arr.get(0);
	    for(int i=1;i < arr.size();i++){ 
	      if((int)arr.get(i)<minValue){ 
	         minValue = (int)arr.get(i); ; 
	      } 
	    } 
	    return minValue; 
	
	}
	
	public int gcd(int a, int b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
	
	
	public void General(){
		
		 int buttons =s.nextInt();
	        int bulbs= s.nextInt();
	        s.nextInt();
	       // String x = s.nextLine();
	        Set<Integer> total = new HashSet<>();
	        while(buttons>0) {
	            String line = s.nextLine();
	            StringTokenizer stringTokenizer = new StringTokenizer(line);
	            while (stringTokenizer.hasMoreTokens()) {
	               total.add(Integer.parseInt(stringTokenizer.nextToken()));
	            }
	 
	            buttons--;
	        }
	        if(total.contains(0))
	        	total.remove(0);
	        if(total.size()==bulbs)
	            System.out.println("YES");
	        else
	            System.out.println("NO");
		
		
		}
		
	
		
		
	

	public static void main(String[] args) {
		ProblemSolving PS= new ProblemSolving();
		PS.General();
		//System.out.println(PS.General());
	

	}

}
