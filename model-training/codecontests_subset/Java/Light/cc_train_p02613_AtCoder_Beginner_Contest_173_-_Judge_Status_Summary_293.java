//package hiougyf;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		 Scanner sc =new Scanner(System.in);
	int t=sc.nextInt();

	 int ac=0,wa=0,tle=0,re=0;
	 while(t-->0) {
		 String s=sc.next();
	 
		 if(s.equals("WA")) {
			 wa++;
		 }
		 if(s.equals("AC")) {
			 ac++;
		 }
		 if(s.equals("TLE")) {
			 tle++;
		 }
		 if(s.equals("RE")) {
			 re++;
		 }
	 }
		 System.out.println("AC x "+ac);
		 System.out.println("WA x "+wa);
		 System.out.println("TLE x "+tle);
		 System.out.println("RE x "+re);
		 
	 
	}
	
}
	