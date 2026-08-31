// CodeForces Round #522 B wrong XXX

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KnigaPodarok {

	int n,m;
	int []a;
	int []cnts;
	int nVars;
	
	private void readData(BufferedReader bin) throws IOException {
		String []ss;
		String s = bin.readLine();
		ss = s.split(" ");
		n = Integer.parseInt(ss[0]);
		m = Integer.parseInt(ss[1]);
		a = new int[n];
		cnts = new int[m];
		s = bin.readLine();
		ss = s.split(" ");
		for (int i=0; i<n; i++) {
			// read m,k,a
			a[i] = Integer.parseInt(ss[i]);
		}
	}
	
	void printRes() {
		System.out.println(nVars);
	}
	
	void countCounts() {
		for (int i=0; i<n; i++) {
			cnts[a[i]-1]++;
		}
	}
	
	private void calculate() {
		Arrays.sort(a);
		countCounts();
		for (int j=0; j<m-1; j++) {
			n -= cnts[j];
			nVars += cnts[j]*n;
		}
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader bin = new BufferedReader(new FileReader("cactus.in"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		KnigaPodarok l = new KnigaPodarok();
		l.readData(bin);
		l.calculate(); // here for each set
		l.printRes();
	}
}
