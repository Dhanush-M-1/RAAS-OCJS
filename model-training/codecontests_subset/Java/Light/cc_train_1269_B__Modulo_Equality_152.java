
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class div2_1_happyReturn {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[]a=new int[n];
		int[]b=new int[n];
		str=br.readLine();
		st=new StringTokenizer(str);
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		str=br.readLine();
		st=new StringTokenizer(str);
		
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			b[i]=num;
		}
	int ans=Integer.MAX_VALUE;
		Arrays.sort(b);
		int i=0;
		int diff=0;
		int element=a[0];
		for(;i<n;i++) {
			if(b[i]>=element)
			diff=Math.abs(b[i]-element);
			else
			diff=m+b[i]-element;	
			int j=0;
			int[]temp=a.clone();
			for(;j<n;j++) {
				temp[j]=(temp[j]+diff)%m ;
			}
			j=0;
			Arrays.sort(temp);
			for(;j<n;j++) {
				if(temp[j]!=b[j])
					break;
			}
			if(j==n)
			{ans=Math.min(diff,ans);}
			
		}
		System.out.println(ans);
	}
	
}
