import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),ans=0;
		int[] a=new int[n],b=new int[n],c=new int[m],d=new int[m];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		for(int i=0;i<m;i++) {
			c[i]=sc.nextInt();
			d[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++) {
			int dis=2000000000;
			for(int j=0;j<m;j++) {
				int distance=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
				if(distance<dis) {
					dis=Math.min(dis,distance);
					ans=j+1;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}