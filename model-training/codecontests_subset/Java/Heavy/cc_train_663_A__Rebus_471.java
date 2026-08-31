import java.util.*;

public class Rebus {	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String line = scan.nextLine();
		String[] S = line.split("=");
		int N = Integer.parseInt(S[1].trim());
		int max = N, min = 1, nplus = 0, nminus = 0;
		
		// This method basically determines whether the number can be expressed by adding/subtracting from the original value
		
		for(char C : S[0].toCharArray()){
			if(C == '+'){
				max += N;
				min++;
				nplus++;
			}
			if(C == '-'){
				max--;
				min -= N;
				nminus++;
			}
		}
		if (max < N || N < min) {
			System.out.println("Impossible");
			return;
		}
		
		int[] add = new int[nplus];
		int[] subtract = new int[nminus + 1];
		for(int C = 0;C < Math.max(nplus, nminus);C++) {
			add[C % nplus]++;
			subtract[C % (nminus + 1)]++;
		}
		
		System.out.print("Possible\n" + (N - subtract[subtract.length - 1]));
		int oplus = 0, ominus = 0;
		for(char C : S[0].toCharArray()){
			if(C == '+'){
				System.out.print(" + " + add[oplus++]);
			}
			if(C == '-'){
				System.out.print(" - " + subtract[ominus++]);
			}
		}
		System.out.println(" = " + N);
	}
}
