import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem551B {
	boolean debug = false;

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public static void main(String[] args) {
		Problem551B instance = new Problem551B();
		BufferedReader bfr = null;

		try {
			bfr = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			String a = "", b = "", c = "";
			if ((line = bfr.readLine()) != null) {
				a = line.trim();
			}
			// if (a.startsWith("pnmrkblwafxaps")) {
			// instance.setDebug(true);
			// }
			if ((line = bfr.readLine()) != null) {
				b = line.trim();
			}
			if ((line = bfr.readLine()) != null) {
				c = line.trim();
			}

			instance.process(a, b, c);

		} catch (Throwable t) {
			System.err.println(t);
		} finally {
			if (bfr != null) {
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void process(String sa, String sb, String sc) {
		int[] a = new int[26];
		int[] b = new int[26];
		int[] c = new int[26];

		for (int i = 0; i < sa.length(); i++) {
			a[sa.charAt(i) - 'a']++;
		}
		for (int i = 0; i < sb.length(); i++) {
			b[sb.charAt(i) - 'a']++;
		}
		for (int i = 0; i < sc.length(); i++) {
			c[sc.charAt(i) - 'a']++;
		}

		int[] temp = new int[26];
		int total=0;
		int mb = 0;
		int mc = 0;

		int maxb = getMaxB(a, b, c, temp);
		int minc = getMaxCGivenB(a, b, c, maxb, temp);
		int maxc = getMaxC(a, b, c, temp);
		int minb = getMaxBGivenC(a, b, c, maxc, temp);
		if(maxc-minc<maxb-minb){
			for(int i=minc;i<=maxc;i++){
				updateTemp(a, temp);
				int valb = getMaxBGivenC(a, b, c, i, temp);
				if(valb+i>total){
					total = valb+i;
					mb = valb;
					mc = i;
				}
			}
		}else{
			for(int i=minb;i<=maxb;i++){
				updateTemp(a, temp);
				int valc = getMaxCGivenB(a, b, c, i, temp);
				if(valc+i>total){
					total = valc+i;
					mb = i;
					mc = valc;
				}
			}
			
		}

		if (debug) {
			System.out.println("maxb:" + mb);
			System.out.println("maxc:" + mc);
			System.out.println("total:" + total);
		}

		for (int i = 0; i < 26; i++) {
			temp[i] = a[i] - (mb * b[i]) - (mc * c[i]);
		}

		StringBuffer msg = new StringBuffer();
		for (int i = 0; i < mb; i++) {
			msg.append(sb);
		}
		for (int i = 0; i < mc; i++) {
			msg.append(sc);
		}
		for (int i = 0; i < 26; i++) {
			while (temp[i] > 0) {
				msg.append((char) ('a' + i));
				temp[i]--;
			}
		}

		System.out.println(msg.toString());
	}

	private void updateTemp(int[] a, int[] temp) {
		for (int i = 0; i < 26; i++) {
			temp[i] = a[i];
		}
	}

	private int getMaxCGivenB(int[] a, int[] b, int[] c, int maxb, int[] temp) {
		for (int i = 0; i < 26; i++) {
			temp[i] -= (maxb * b[i]);
		}

		int maxc = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (c[i] > 0) {
				maxc = Math.min(maxc, (temp[i] / c[i]));
			}
		}
		if (maxc == Integer.MAX_VALUE) {
			maxc = 0;
		}
		return maxc;
	}

	private int getMaxBGivenC(int[] a, int[] b, int[] c, int maxc, int[] temp) {
		for (int i = 0; i < 26; i++) {
			temp[i] -= (maxc * c[i]);
		}

		int maxb = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (b[i] > 0) {
				maxb = Math.min(maxb, (temp[i] / b[i]));
			}
		}
		if (maxb == Integer.MAX_VALUE) {
			maxb = 0;
		}
		return maxb;
	}

	private int getMaxB(int[] a, int[] b, int[] c, int[] temp) {
		updateTemp(a, temp);

		int maxb = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (b[i] > 0) {
				maxb = Math.min(maxb, (temp[i] / b[i]));
			}
		}
		if (maxb == Integer.MAX_VALUE) {
			maxb = 0;
		}

		return maxb;
	}

	private int getMaxC(int[] a, int[] b, int[] c, int[] temp) {
		updateTemp(a, temp);

		int maxc = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			if (c[i] > 0) {
				maxc = Math.min(maxc, (temp[i] / c[i]));
			}
		}
		if (maxc == Integer.MAX_VALUE) {
			maxc = 0;
		}

		return maxc;
	}

}
