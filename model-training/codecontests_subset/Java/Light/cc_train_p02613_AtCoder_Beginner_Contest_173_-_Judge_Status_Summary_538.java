import java.util.*;
public class Main {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int n = scn.nextInt();
		for(int i=0;i<n;i++) {
			String s=scn.next();
			if(s.equals("AC")) {
				a+=1;
			}else if(s.equals("WA")) {
				b++;
			}else if(s.equals("TLE")) {
				c++;
			}else if(s.equals("RE")) {
				d++;
			}
		}System.out.print("AC x ");
		System.out.println(a);
		System.out.print("WA x ");
		System.out.println(b);
		System.out.print("TLE x ");
		System.out.println(c);
		System.out.print("RE x ");
		System.out.println(d);
	}
}