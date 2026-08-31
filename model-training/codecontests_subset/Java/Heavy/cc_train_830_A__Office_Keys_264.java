import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int p=scanner.nextInt();
		long []a=new long[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		a=sort(a,n);
		long b[]=new long[k];
		for(int i=0;i<k;i++) {
			b[i]=scanner.nextInt();
		}
		b=sort(b,k);
		
		long f[][]=new long[n+1][k+1];
		for(int i=1;i<=n;i++) {
			for(int j=i;j<=k;j++) {
				if(i<j) {
					f[i][j]=min(max(f[i-1][j-1],abs(a[i-1]-b[j-1])+abs(b[j-1]-p)),f[i][j-1]);
				}else {
					f[i][j]=max(f[i-1][j-1],abs(a[i-1]-b[j-1])+abs(b[j-1]-p));
				}
				
			}
		}
		long ans=f[n][n];
		for(int i=n;i<=k;i++) {
			if(ans>f[n][i]) {
				ans=f[n][i];
			}
		}
		System.out.println(ans);
	}
	public static long abs(long x) {
		if(x>0) {
			return x;
		}else {
			return-x;
		}
	}
	public static long max(long x,long y) {
		if(x<y) {
			return y;
		}else {
			return x;
		}
	}
	public static long min(long x,long y) {
		if(x<y) {
			return x;
		}else {
			return y;
		}
	}
	public static long[] sort(long node[], int n) {
		if (n > 1) {
			int p = n / 2;
			long B[] = new long[p];
			long C[] = new long[n - p];
			for (int i = 0; i < p; i++) {
				B[i] = node[i];
			}
			for (int i = 0; i < n-p; i++) {
				C[i] = node[i+p];
			}
			B=sort(B, p);
			C=sort(C, n - p);
			node = merge(B, C, p, n - p);
		}
		return node;
	}

	public static long[] merge(long[] B, long[] C, int nb, int nc) {
		int n = nb + nc;
		long A[] = new long[n];
		int i = 0;
		int j = 0;
		for (int k = 0; k < n; k++) {
			if (i < nb && (j >= nc || B[i] <= C[j])) {
				A[k] = B[i];
				i++;
			} else {
				A[k] = C[j];
				j++;
			}
		}
		return A;
	}

}

