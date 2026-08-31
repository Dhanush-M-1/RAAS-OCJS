
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] cmd=br.readLine().split(" ");
		int n=Integer.valueOf(cmd[0]);
		int m=Integer.valueOf(cmd[1]);
		int[] a=new int[n];
		int[] b=new int[n];
		cmd=br.readLine().split(" ");
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.valueOf(cmd[i]);
		}
		cmd=br.readLine().split(" ");
		for(int i=0;i<n;i++)
		{
			b[i]=Integer.valueOf(cmd[i]);
		}
		int ans=1000000000;
		int g=b[0];
		for(int i=0;i<n;i++)
		{
			int x=((g-a[i])%m+m)%m;
			int[] arr=new int[n];
			for(int j=0;j<n;j++)
			{
				arr[j]=(a[j]+x)%m;
			}
			Arrays.sort(arr);
			Arrays.sort(b);
			int bool=0;
			for(int j=0;j<n;j++)
			{
				if(arr[j]!=b[j])
				{
					bool=1;
					break;
				}
			}
			if(bool==0)
				ans=Math.min(x,ans);
		}
		System.out.println(ans);
	}

}
