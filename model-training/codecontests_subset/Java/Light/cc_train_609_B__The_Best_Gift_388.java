import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main{
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str[]=br.readLine().split(" ");
		int n=Integer.parseInt(str[0]);
		int m=Integer.parseInt(str[1]);
		str=br.readLine().split(" ");
		int arr[]=new int[n];
		int freq[]=new int[m+1];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(str[i]);
			freq[arr[i]]++;
		}
		long sum[]=new long[m+1];
		for(int i=1;i<=m;i++){
			sum[i]=sum[i-1]+freq[i];
		}
		long ans=0;
		for(int i=1;i<=m;i++){
			long val=sum[m]-freq[i];
			ans=ans+(freq[i]*val);
		}
		System.out.println(ans/2);
	}
}
