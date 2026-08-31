import java.io.PrintWriter;
import java.util.Scanner;

public class FleetFunding {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String a = in.nextLine();
		String b = in.nextLine();
		String c = in.nextLine();
		
		int[] freqA = new int[26];
		int[] freqB = new int[26];
		int[] freqC = new int[26];

		for(char i : a.toCharArray()) {
			freqA[i - 'a']++;
		}
		for(char i : b.toCharArray()) {
			freqB[i - 'a']++;
		}
		for(char i : c.toCharArray()) {
			freqC[i - 'a']++;
		}
		
		// make some amount of b's
		
		int ansB = 0;
		int ansC = 0;
		
	mug:for(int i=0; i<a.length(); i++) {
			
			int[] copy = new int[26];
			for(int j=0; j<26; j++) {
				copy[j] = freqA[j];
			}
			
			for(int j=0; j<26; j++) {
				
				if(freqB[j] * i > freqA[j]) {
					break mug;
				}
				else {
					copy[j] -= (freqB[j] * i);
				}
			}
			
			int cMake = 99999999;
			for(int j=0; j<26; j++) {
				
				if(freqC[j] > 0) {
					cMake = Math.min(cMake, copy[j]/freqC[j]);
				}
			}
			
			if(cMake + i > ansB + ansC) {
				ansB = i;
				ansC = cMake;
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
	
		for(int i=0; i<ansB; i++) {
			sb.append(b);
		}
		for(int i=0; i<ansC; i++) {
			sb.append(c);
		}
	
		for(int i=0; i<26; i++) {
			freqA[i] -= (ansB * freqB[i]);
			freqA[i] -= (ansC * freqC[i]);
		}
		
		for(int i=0; i<26; i++) {
			for(int j=0; j<freqA[i]; j++) {
				sb.append((char)(i + 'a'));
			}
		}
		
		System.out.println(sb);
	}
}
