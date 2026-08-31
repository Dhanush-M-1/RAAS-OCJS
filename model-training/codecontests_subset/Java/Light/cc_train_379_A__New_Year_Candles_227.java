import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int m = sc.nextInt();
	    
	    if(n<m){
	        System.out.println(n);
	    }
	    else{
	        
    	    int d = n/m;
    	    int l = n%m;
    	    int c = d;
    	    while((d+l) >= m){
    	        d = d+l;
    	        l = d%m;
    	        d = d/m;
    	        c += d;
    	    }
    	    System.out.println(c+n);
	    }
	}
}
