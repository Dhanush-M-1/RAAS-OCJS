import java.util.*;
 
public class Main
{   
    public static long gcd(long x, long y){
        if(y==0) 
            return x;
	    else 
	        return gcd(y, x%y);
    }
    
    public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long x = scan.nextLong();
		
		long y = (long)Math.sqrt(x);
		
		while(true){
		    if(x%y==0){
			    long a=y;
			    long b=x/y;
			    if(a*b/gcd(a,b)==x){
				    System.out.println(a +" "+ b);
				    break;
			    }
		    }
		    y--;
    	}
		
	}
}