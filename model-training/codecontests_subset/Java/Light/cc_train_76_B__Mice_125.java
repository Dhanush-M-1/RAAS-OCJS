import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		scan.nextInt();
		scan.nextInt();
		long[] mxs = new long[n];
		long[] cxs = new long[m];
		for(int i=0;i<n;i++) {
			mxs[i] = scan.nextLong();
		}
		for(int i=0;i<m;i++) {
			cxs[i] = scan.nextLong();
		}
		int ptrM = 0;
		int ptrC = 0;
		long[] eaten = new long[m];
		int[] targets = new int[n];
		Arrays.fill(eaten, -1);
		while(ptrM < n) {
			long mx = mxs[ptrM];
			while(ptrC < cxs.length-1 && Math.abs(cxs[ptrC+1]-mx) < Math.abs(cxs[ptrC]-mx)) {
				ptrC++;
			}
			long dist = Math.abs(cxs[ptrC] - mx);
			while((eaten[ptrC] != dist && eaten[ptrC] != -1) && ptrC < cxs.length-1 && Math.abs(cxs[ptrC+1]-mx) == Math.abs(cxs[ptrC]-mx))
				ptrC++;
			// System.out.println(ptrM + " " + ptrC);
			if(dist < eaten[ptrC] || eaten[ptrC] == -1)
				eaten[ptrC] = dist;
			targets[ptrM] = ptrC;
			ptrM++;
		}
		// System.out.println(Arrays.toString(eaten));
		int hungry = 0;
		for(int i=0;i<n;i++) {
			long dist = Math.abs(cxs[targets[i]] - mxs[i]);
			// System.out.println(i + " is dist " + dist + " from " + targets[i]);
			
			if(dist != eaten[targets[i]]) {
				hungry++;
				// System.out.println(i + " is hungry");
			}
		}
		System.out.println(hungry);
	}
}
