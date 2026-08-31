import java.io.*;
import java.util.*;//java.util.scanner
import java.lang.*;//java.lang.Math
import java.text.*;
import java.math.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t=new StringTokenizer(re.readLine());
		int n=Integer.parseInt(t.nextToken()),m=Integer.parseInt(t.nextToken());
		int[] a=new int[20004], b=new int[20004], c=new int[5003], e=new int[5003]; 
		for(int i=1;i<=n;++i)e[i]=n;
		for(int i=0;i<m;++i) {
			t=new StringTokenizer(re.readLine());
			a[i]=Integer.parseInt(t.nextToken());
			b[i]=Integer.parseInt(t.nextToken());
			if((b[i]-a[i]+n)%n<e[a[i]])e[a[i]]=(b[i]-a[i]+n)%n;
			++c[a[i]];
		}
		for(int i=1;i<=n;++i) {
			int ans=0;
			for(int j=1;j<=n;++j) {
				if(c[j]>0&&ans < c[j]*n-n+(j-i+n)%n + e[j]) ans = c[j]*n-n+(j-i+n)%n + e[j];
			}
			System.out.print(ans+" ");
		}
	}
}
