import java.io.PrintWriter;
import java.util.*;

public class ZgukistringZ
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		Word a = new Word(scan.nextLine());
		Word b = new Word(scan.nextLine());
		Word c = new Word(scan.nextLine());

		
		int max = count(a.freq, b.freq);
		
		int best = 0;
		int num = 0;
		int rest = 0;
		for(int i = 0; i <= max; i++) {
			int[] r = sub(a.freq, b.freq, i);
			int res = count(r, c.freq);
			if(i+res > best) {
				best = i+res;
				num = i;
				rest = res;
			}
		}
		
		int[] f = sub(a.freq, b.freq, num);
		f = sub(f, c.freq, rest);
		
		for(int i = 0; i < num; i++) out.print(b.s);
		for(int i = 0; i < rest; i++) out.print(c.s);
		for(int i = 0; i < 26; i++) {
			while(f[i] > 0) {
				f[i]--;
				out.print((char)(i+'a'));
			}
		}
		out.flush();
	}

	static int count(int[] f1, int[] f2) {
		int res = Integer.MAX_VALUE;
		for(int i = 0; i < 26; i++) {
			if(f2[i] != 0)
				res = Math.min(res, f1[i]/f2[i]);
		}
		return res;
	}

	static int[] sub(int[] f1, int[] f2, int c) {
		int[] res = new int[26];
		for(int i = 0; i < 26; i++) {
			res[i] = f1[i]-(c*f2[i]);
			if(res[i] < 0) System.out.println("FXXK");
		}
		return res;
	}

	static class Word{

		String s;
		int[] freq;

		public Word(String s) {
			this.s = s;
			this.freq = new int[26];
			for(int i = 0; i < s.length(); i++) {
				freq[s.charAt(i)-'a']++;
			}
		}
	}
}
