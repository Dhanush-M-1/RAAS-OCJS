
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class qq {

	public static void main(String[] args) throws  IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		Integer a[]=new Integer[n];
		st=new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i]=Integer.parseInt(st.nextToken());
			
		}
		Arrays.sort(a);
		int min=1000000;
		for(int r=0;r<=a[n-1];r++) {
			int l=0;
			int mid=r;
			
			Integer b[]=new Integer[n];
			Arrays.fill(b, 1000000);
			int w=0;
			for (int i = 0; i < a.length; i++) {
				int x=a[i];
				int q=0;
				while(x>mid) {
					q++;
					x/=2;
				}
				if(x==mid) {
					w++;
					b[i]=q;
				}		
			}
			Arrays.sort(b);
			for (int i = 0; i < k; i++) {
				l+=b[i];
			}
			min=Math.min(l,min);
		}
		pw.print(min);
		pw.flush();
	}
	
	
}