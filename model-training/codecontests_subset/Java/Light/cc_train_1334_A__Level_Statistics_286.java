import java.util.*;
public class LevelStatistics {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t--!=0) {
			int n=sc.nextInt();
			int p[]=new int[n],c[]=new int[n];
			for(int i=0;i<n;i++) {
				p[i]=sc.nextInt();c[i]=sc.nextInt();
			}
			boolean f=true;
			for(int i=1;i<n;i++) {
				if(p[i]<p[i-1] || c[i]-c[i-1]>p[i]-p[i-1] ||c[i]<c[i-1]) {
					f=false;break;
				}
			}
			if(p[0]<c[0])f=false;
			if(f)System.out.println("YES");
			else System.out.println("NO");
		}

	}

}