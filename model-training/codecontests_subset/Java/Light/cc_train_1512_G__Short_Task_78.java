//https://codeforces.com/contest/1512/problem/G
//G. Short Task
import java.util.*;
import java.io.*;
public class CF_1512_G{
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = 10000000+1;

		int p[] = new int[n];
		int sum[] = new int[n];
		int ans[] = new int[n];

		for(int i=2;i*i<n;i++){
			if(p[i]==0)
				for(int j=i*i;j<n;j+=i)
					if(p[j]==0)
						p[j] = i;
		}

		sum[1] = 1;
		for(int i=2;i<n;i++){
			if(p[i]==0)
				sum[i] = 1+i;
			else{
				sum[i] = 1;
				int j = i;
				while(j%p[i]==0){
					j /=p[i];
					sum[i] = sum[i]*p[i]+1;
				}
				sum[i] *= sum[j];
			}
		}

		Arrays.fill(ans, -1);
		for(int i=n-1;i>=0;i--){
			if(sum[i]<n)
				ans[sum[i]] = i;
		}

		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			int x = Integer.parseInt(br.readLine());
			sb.append(ans[x]).append("\n");
		}

		pw.print(sb);
		pw.flush();
		pw.close();
	}
}

//simple solution
/*
		int n = 10000000+1;

		int a[] = new int[n];
		int ans[] = new int[n];

		for(int i=1;i<n;i++){
			ans[i] = -1;
			for(int j=i;j<n;j+=i)
				a[j] += i;
		}

		for(int i=n-1;i>=0;i--){
			if(a[i]<n)
				ans[a[i]] = i;
		}

		int t = Integer.parseInt(br.readLine());

		while(t-->0){
			int x = Integer.parseInt(br.readLine());
			sb.append(ans[x]).append("\n");
		}
*/