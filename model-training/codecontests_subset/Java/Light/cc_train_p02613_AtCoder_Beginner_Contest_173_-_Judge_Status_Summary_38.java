import java.util.Scanner;
//import java.util.Arrays;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//
		long n = sc.nextLong();
		String s = "";
		long ac = 0, wa = 0, tle = 0, re = 0;
		for(long i=0; i<n; i++){
			s = sc.next();
			if(s.equals("AC")){
				ac++;
			}else if(s.equals("WA")){
				wa++;
			}else if(s.equals("TLE")){
				tle++;
			}else{
				re++;
			}
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}
