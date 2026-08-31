import java.util.Arrays;
import java.util.Scanner;


public class Troll {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String a = scanner.next();
		String b = scanner.next();
		String c = scanner.next();
	
		int[] aa = new int[26];
		int[] bb = new int[26];
		int[] cc = new int[26];
		
		for(int i = 0; i < a.length(); ++i) aa[a.charAt(i) - 'a']++;
		for(int i = 0; i < b.length(); ++i) bb[b.charAt(i) - 'a']++;
		for(int i = 0; i < c.length(); ++i) cc[c.charAt(i) - 'a']++;
		
		int max = (int)1e6;
		for(int i = 0; i < 26 ; ++i) {
			if(bb[i] > 0) {
				max = Math.min(max, aa[i] / bb[i]);
			}
		}
		
		int minb = 0;
		int minc = 0;
		
		for(int i = 0; i <= max ; ++i) {
			int m = (int)1e6;
			for(int j = 0; j < 26 ; ++j) {
				if(cc[j] > 0) {
					m = Math.min(m, (aa[j] - i * bb[j]) / cc[j]);
				}
			}
			if(m != (int)1e6 && i + m > minb + minc) {
				minb = i;
				minc = m;
			}
			
		}
		//System.out.println(minb + " " + minc);
	//	System.err.println("yes");
		StringBuilder kBuilder = new StringBuilder();
		for(int i = 0; i < minb ; ++i) {
			kBuilder.append(b);
		}
		for(int i = 0; i < 26 ; ++i) {
			 aa[i] -= bb[i] * minb;
		}
		
		
		for(int i = 0; i < minc ; ++i) {
			kBuilder.append(c);
		}
		for(int i = 0; i < 26 ; ++i) {
			aa[i] -= cc[i] * minc;
		}
		
	//	System.err.println("yes");
		for(int i = 0; i < 26 ; ++i) {
			for(int j = 0; j < aa[i] ; ++j) kBuilder.append((char)(i + 'a'));
		}
		
	//	System.err.println("yes");
		
		System.out.println(kBuilder);

		
		

	}

}


