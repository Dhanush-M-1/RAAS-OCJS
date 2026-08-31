import java.util.*;
public class Main{
	public static void main (String []args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
			int n=sc.nextInt();
			int p[]=new int[n];
			int c[]=new int[n];
			for(int i=0;i<n;i++) {
				p[i]=sc.nextInt();
				c[i]=sc.nextInt();
			}
			boolean flag =true;
			for(int i=0;i<n-1;i++) {
				if(p[i]>p[i+1]||c[i]>c[i+1])flag=false;
				if(p[i]==p[i+1]&&c[i]!=c[i+1])flag=false;
				if(p[i]<c[i])flag=false;
				if((p[i+1]-p[i])<(c[i+1]-c[i]))flag=false;
			}
			if(p[p.length-1]<c[c.length-1])flag=false;
			if(flag)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}