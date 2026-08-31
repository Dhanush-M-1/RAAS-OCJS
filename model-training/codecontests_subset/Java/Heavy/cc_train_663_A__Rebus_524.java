import java.util.*;
import java.io.*;

public class B664
{

	public static void main(String[] args) throws Exception
	{
		Scanner in = new Scanner(System.in);
		String reb = in.nextLine();
		StringTokenizer st = new StringTokenizer(reb);
      
   		int plus = 0, minus = 0, n = 0;
		while (st.hasMoreTokens()){
			String next = st.nextToken();
			if (next.equals("?")) {
				if(plus == 0)
					plus++;
			}
			else if (next.equals("+")) {
				plus++;
			}
			else if (next.equals("-")) {
				minus++;
			}
			else if (next.equals("=")) {
			}
			else n = Integer.parseInt(next);
		}

		int p = n/plus;
		int[] ps = new int[plus];
		int[] ms = new int[minus];
		for (int i = 0; i < minus; i++) {
			ms[i] = 1;
		}
		int mod = n%plus+minus;
		if (p < 1) {
			p = 1;
			if(mod >= plus) {
				mod -= plus;
			}
			else {
				int add = plus - mod;
				int cur = 0;
				while (cur < minus && add > 0) {
					if (ms[cur] < n) {
						ms[cur]++;
						add--;
					}
					else
						cur++;
				}
				if (cur >= minus || add > 0) {
					System.out.println("Impossible");
					return;
				}
				mod = 0;
			}
		}
		for (int i = 0; i < plus; i++) {
			ps[i] = p;
		}
		
		int cur = 0;
		while (cur < plus && mod > 0) {
			if (ps[cur] < n) {
				ps[cur]++;
				mod--;
			}
			else
				cur++;
		}
		if (cur < plus && mod == 0 ) {
			System.out.println("Possible");
			int temp = 1;
			int curp = 0;
			int curm = 0;
			for (int i = 0; i < reb.length(); i++) {
				if (reb.charAt(i) == '?') {
					if(temp == 1)
						System.out.print(ps[curp++]);
					else
						System.out.print(ms[curm++]);
				}
				else 
				{
					if (reb.charAt(i) == '-') 
						temp = 2;
					if (reb.charAt(i) == '+') 
						temp = 1;
					System.out.print(reb.charAt(i));
				}
			}
			System.out.println();
		}
		else {
			System.out.println("Impossible");
		}

	}
}