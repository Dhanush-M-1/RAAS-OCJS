// CodeForces Round #673 D competition

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BearTwoPaths {
	
	int n,k;
	int a,b,c,d;
	int []pa;
	int []pb;

	private void readData(BufferedReader bin) throws IOException {
		String s = bin.readLine();
		String []ss = s.split(" ");
		n = Integer.parseInt(ss[0]);
		k = Integer.parseInt(ss[1]);
		// read t
		s = bin.readLine();
		ss = s.split(" ");
		a = Integer.parseInt(ss[0]);
		b = Integer.parseInt(ss[1]);
		c = Integer.parseInt(ss[2]);
		d = Integer.parseInt(ss[3]);
	}

	void printRes() {
		if (pa==null) {
			System.out.println(-1);
			return;
		}
		for (int i=0; i<n; i++) {
			System.out.print(pa[i] + " ");
		}
		System.out.println();
		for (int i=0; i<n; i++) {
			System.out.print(pb[i] + " ");
		}
		System.out.println();
	}
	

	private void calculate() {
		if (n==4 || k<n+1) {
			pa = null;
			return;
		}
		pa = new int[n];
		pb = new int[n];
		// moving a->0 c->1 d->2 b->n-1 
		int []idx = new int[n];
		idx[0] = a;
		idx[1] = c;
		idx[n-2] = d;
		idx[n-1] = b;
		int ii = 1;
		// fill all other indexes
		for (int i=2; i<n-2; i++) {
			while (!(ii!=a && ii!=b && ii!=c && ii!=d)) {
				ii++;
			}
			idx[i] = ii++;
		}
		for (int i=0; i<n; i++) {
			pa[i] = idx[i];
			pb[i] = idx[i];
		}
		pb[0] = c;
		pb[1] = a;				
		pb[n-2] = b;
		pb[n-1] = d;		
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader bin = new BufferedReader(new FileReader("cactus.in"));
		BufferedReader bin = new BufferedReader(
				new InputStreamReader(System.in));
		BearTwoPaths l = new BearTwoPaths();
		l.readData(bin);
		l.calculate();
		l.printRes();
	}
}
