import java.util.*;
public class contest2d {
	static int[] a=new int[1000000];
	static int[] b=new int[1000000];
	static long[][] d=new long[2003][2003];
	static long[][] ans=new long[2003][2003];
	static Scanner inp=new Scanner(System.in);
	public static long abs(long x){
		if(x<0)return(-x);
		return(x);
	}
	public static long max(long x,long y){
		if (x>y)return(x);
		return(y);
	}
	public static long min(long x,long y){
		if (x<y)return(x);
		return(y);
	}
	public static void sort(int x,int y){
		int l=x;
		int r=y;
		int mid=a[(l+r)/2];
		while(l<r){
			while (a[l]<mid)l++;
			while (a[r]>mid)r--;
			if (l<=r){
				int z=a[l];a[l]=a[r];a[r]=z;
				l++;r--;
			}
		}
		if (l<y)sort(l,y);
		if (r>x)sort(x,r);
	}
	public static void sortb(int x,int y){
		int l=x;
		int r=y;
		int mid=b[(l+r)/2];
		while(l<r){
			while (b[l]<mid)l++;
			while (b[r]>mid)r--;
			if (l<=r){
				int z=b[l];b[l]=b[r];b[r]=z;
				l++;r--;
			}
		}
		if (l<y)sortb(l,y);
		if (r>x)sortb(x,r);
	}
	public static void main(String[] args) {
		int n=inp.nextInt();
		int m=inp.nextInt();
		int p=inp.nextInt();
		for (int i=1;i<=n;i++)
		    a[i]=inp.nextInt();
		for (int i=1;i<=m;i++)
			b[i]=inp.nextInt();
		sort(1,n);
		sortb(1,m);
		for (int i=1;i<=n;i++)
			for (int j=1;j<=m;j++)
				d[i][j]=abs(a[i]-b[j])+abs(b[j]-p);
		for (int i=1;i<=n;i++)
			for (int j=0;j<=m;j++){
				ans[i][j]=2000000;
				ans[i][j]=ans[i][j]*ans[i][j];
			}
		ans[0][0]=0;
		for (int i=1;i<=n;i++) ans[i][i]=max(ans[i-1][i-1],d[i][i]);
		for (int i=1;i<=n;i++)
			for (int j=i;j<=m;j++)
				ans[i][j]=min(ans[i][j-1],max(ans[i-1][j-1],d[i][j]));
		System.out.print(ans[n][m]);
	}

}
