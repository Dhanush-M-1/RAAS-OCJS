import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ZgukistringZ {
	public static void main(String[] args) throws IOException {
		int[] occ = new int[26];
		int[] occb = new int[26];
		int[] occc = new int[26];
		Scanner br = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		String sa = br.nextLine();
		String sb = br.nextLine();
		String sc = br.nextLine();
		char[] a = sa.toCharArray();
		char[] b = sb.toCharArray();
		char[] c = sc.toCharArray();

		for (int i = 0; i < a.length; i++) {
			occ[a[i]-'a']++;
		}

		int maxb = a.length;
		int minc = a.length;
		
		for (int i = 0; i < b.length; i++) {
			occb[b[i] - 'a']++;
		}
		for (int i = 0; i < c.length; i++) {
			occc[c[i] - 'a']++;
		}
		
		for (int i = 0; i < occb.length; i++) {
			if(occb[i] != 0) maxb = Math.min(maxb, occ[i]/occb[i]);
		}
		
		int cb = maxb;
		int max = maxb;
		int cc = 0;
		for (int j= 0; j <= max; j++) {
			for (int i = 0; i < occc.length; i++) {
				if(occc[i] != 0){
					int x = (occ[i] - occb[i]*j)/occc[i];
					minc = Math.min(minc, x);
				}
			}			
			if(minc + j > maxb){
				cc = minc;
				cb = j;
				maxb = minc + j;
			}
		}
				
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < cb; i++) {
			ret.append(sb);
		}
		for (int i = 0; i < cc; i++) {
			ret.append(sc);
		}
		for (int i = 0; i < occ.length; i++) {
			occ[i] -= (occb[i] * cb + occc[i] * cc);
			while(occ[i] > 0){
				ret.append((char)(i+'a'));
				occ[i]--;
			}
		}
		pw.println(ret);
		pw.flush();
		pw.close();
	}
}
