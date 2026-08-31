import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] S = new int[13];
		int[] H = new int[13];
		int[] C = new int[13];
		int[] D = new int[13];
		for (int i=0; i<n; i++) {
			String temp_s = sc.next();
			int temp_i = sc.nextInt()-1;
			if (temp_s.equals("S")) {S[temp_i]++;}
			else if (temp_s.equals("H")) {H[temp_i]++;}
			else if (temp_s.equals("C")) {C[temp_i]++;}
			else if (temp_s.equals("D")) {D[temp_i]++;}
		}
		
		for (int i=0; i<13; i++) {
			if (S[i]==0) {System.out.println("S"+" "+(i+1));}
		}
		for (int i=0; i<13; i++) {
			if (H[i]==0) {System.out.println("H"+" "+(i+1));}
		}
		for (int i=0; i<13; i++) {
			if (C[i]==0) {System.out.println("C"+" "+(i+1));}
		}
		for (int i=0; i<13; i++) {
			if (D[i]==0) {System.out.println("D"+" "+(i+1));}
		}
	}
}
