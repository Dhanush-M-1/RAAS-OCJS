// CodeForces Round #228 div 2 D  XXX request count between additions

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class RemontFabriki {

	class SegmentTree {
		
		final int LEAF = 0x40000;  // 262144 > 200000
		long bound = 0;
		long []tree = new long[LEAF+LEAF];
		
		void upd(int x, long v) {
			x += LEAF;
			tree[x] = Math.min(v,  bound);
			while ((x >>= 1) != 0) {
				tree[x] = tree[x+x] + tree[x+x+1];
			}		
		}

		long get (int x, int y) {
			long ret = 0;
			x += LEAF; 
			y += LEAF;
			while(x <= y) {
				if( (x & 1) !=0) ret += tree[x];
				if((~y & 1) !=0) ret += tree[y];
				x = (x+1) >> 1;
				y = (y-1) >> 1;
			}
			return ret;
		}
	}

	int n,k,a,b,q;
	int []pd;
	int []aa;
	int []req;	
	long []za;
	SegmentTree suma = new SegmentTree();
	SegmentTree sumb = new SegmentTree();
	List<Long> ans = new ArrayList<>();
	
	private void readData(BufferedReader bin) throws IOException {
		String s = bin.readLine();
		String []ss = s.split(" ");
		n = Integer.parseInt(ss[0]);
		k = Integer.parseInt(ss[1]);
		a = Integer.parseInt(ss[2]);
		b = Integer.parseInt(ss[3]);
		q = Integer.parseInt(ss[4]);		
		
		za = new long[n];
		suma.bound = a;
		sumb.bound = b;
		req = new int[q];
		pd = new int[q];
		aa = new int[q];
		for (int i=0; i<q; i++) {
			s = bin.readLine();
			ss = s.split(" ");
			req[i] = Integer.parseInt(ss[0]);
			pd[i] = Integer.parseInt(ss[1])-1;
			if (req[i] == 1) {
				aa[i] = Integer.parseInt(ss[2]);
			}
		}
		bin.close();
	}
	
	void printRes() {
		for (long a : ans) {
			System.out.println(a);
		}
	}
	
	private void calculate() {
		// preparing answers
		for (int i=0; i<q; i++) {
			if (req[i] == 1) {
				long v = za[pd[i]] + aa[i];
				za[pd[i]] = v;
				suma.upd(pd[i], v);
				sumb.upd(pd[i], v);				
			} else if (req[i] == 2) {
				// before remont
				long nz = sumb.get(0, pd[i]-1);
				// after remont, skip k point
				nz += suma.get(pd[i]+k, n-1);
				ans.add(nz);
			}
		}		
	}

	public static void main(String[] args) throws IOException {
		// BufferedReader bin = new BufferedReader(new FileReader("cactus.in"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		RemontFabriki l = new RemontFabriki();
		l.readData(bin);
		l.calculate();
		l.printRes();
	}
}
