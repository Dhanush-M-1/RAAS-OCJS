import java.util.*;

class Main{
	public static void main(String[] $){
		//System.err.println();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt(),r=0;
		int[]a=new int[n],c=new int[n];
		for(int i=0;i<n;++i)
			a[i]=s.nextInt();
		for(int i=0;i<n;++i)
			r+=s.nextInt();
		for(int i=1;i<n;++i)
			c[i]=s.nextInt();

		for(int i=0;i<n-1;++i) 
			if(a[i]+1==a[i+1])
				r+=c[a[i]];

		System.out.println(r);
	}
}
