import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		int ac=0;
		int tle=0;
		int wa=0;
		int re=0;
	    while(t-->0) {
	    	String str=sc.nextLine();
	    	if(str.equals("AC")) ac++;
	    	if(str.equals("TLE")) tle++;
	    	if(str.equals("WA")) wa++;
	    	if(str.equals("RE")) re++;
	    }
	    
	    System.out.println("AC"+" "+"x"+" "+ac);
	    System.out.println("WA"+" "+"x"+" "+wa);
	    System.out.println("TLE"+" "+"x"+" "+tle);
	    System.out.println("RE"+" "+"x"+" "+re);
	}

}
