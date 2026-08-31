import java.util.*;

class Main{
	public static void main(String[] $){
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),m=s.nextInt();
		long[]a=new long[n+1];
		for(int i=0;i<m;++i)
			a[s.nextInt()]=-1;

		a[0]=1;
		for(int i=1;i<=n;++i) {
			if(a[i]==-1) {
				a[i]=0;
				continue;
			}

			a[i]=a[i-1];
			if(i>=2) {
				a[i]+=a[i-2];
				a[i]%=1000000007;
			}
		}
		System.err.println(Arrays.toString(a));
		System.out.println(a[n]);
	}
}