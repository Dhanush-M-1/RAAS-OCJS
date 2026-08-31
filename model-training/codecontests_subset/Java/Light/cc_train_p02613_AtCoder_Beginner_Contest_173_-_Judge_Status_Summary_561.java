import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] S = new String[N];
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		for(int i=0; i<N; i++) {
			S[i] = sc.next();
			if(S[i].contains("AC")) a++;
			if(S[i].contains("WA")) b++;
			if(S[i].contains("TLE")) c++;
			if(S[i].contains("RE")) d++;
		}
		sc.close();
		System.out.println("AC x " + a);
		System.out.println("WA x " + b);
		System.out.println("TLE x " + c);
		System.out.println("RE x " + d);
	}

}