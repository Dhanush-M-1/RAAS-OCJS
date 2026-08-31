import java.util.*;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int A=0,W=0,T=0,R=0;
		for(int i=0;i<N;i++) {
			String s=sc.next();
			if(s.equals("AC")) A++;
			else if(s.equals("WA")) W++;
			else if(s.equals("TLE")) T++;
			else R++;
			
		}
		sc.close();
		System.out.println("AC x "+A);
		System.out.println("WA x "+W);
		System.out.println("TLE x "+T);
		System.out.println("RE x "+R);
	}

}