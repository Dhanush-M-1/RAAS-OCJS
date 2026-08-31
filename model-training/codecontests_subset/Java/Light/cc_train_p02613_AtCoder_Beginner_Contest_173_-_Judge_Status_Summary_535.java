import java.util.*;
import java.math.RoundingMode;
import java.math.BigDecimal;
 
 
 
public class Main{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] count = new int[4];
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			if(s.equals("AC")) count[0]++;
			else if(s.equals("WA")) count[1]++;
			else if(s.equals("TLE")) count[2]++;
			else if(s.equals("RE")) count[3]++;
		}
		System.out.println("AC x "+count[0]);
		System.out.println("WA x "+count[1]);
		System.out.println("TLE x "+count[2]);
		System.out.println("RE x "+count[3]);
	}
}