import java.util.*;

public class B551 {
	
	static public void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		
		long[] ca, cb, cc;
		ca = new long[26];
		cb = new long[26];
		cc = new long[26];
		
		String a = reader.next();
		String b = reader.next();
		String c = reader.next();
		for(int i=0;i<a.length();i++) {
			ca[a.charAt(i)-'a']++;
		}
		for(int i=0;i<b.length();i++) {
			cb[b.charAt(i)-'a']++;
		}
		for(int i=0;i<c.length();i++) {
			cc[c.charAt(i)-'a']++;
		}
		long n2 = 100000;
		long sol1 = 0, sol2 = 0;
		for(long n1 = 0;n1<=100000;n1++) {
			boolean good;
			do {
				good = true;
				for(int i=0;i<26;i++)
					if(n1*cb[i] + n2*cc[i] > ca[i]) {
						good = false; n2--;
					}
			} while(good == false && n2 >= -1);
			if(n2 >= 0 && n1+n2 > sol1+sol2) {
				sol1 = n1; sol2 = n2;
			}
		}
		for(int i=0;i<sol1;i++)
			System.out.print(b);
		for(int i=0;i<sol2;i++)
			System.out.print(c);
		for(int i=0;i<26;i++)
			for(int k=0;k<ca[i]-sol1*cb[i]-sol2*cc[i];k++)
				System.out.print((char)('a'+i));
	}
}
