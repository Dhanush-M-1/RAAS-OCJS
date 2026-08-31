import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_Div2_350 {
	public static void main(String[]arg) throws IOException
	{
		new B_Div2_350().solve();
	}
	public void solve()throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int l,r,n,k,size;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken()) - 1;
		int[]a = new int[n];
		st = new StringTokenizer(in.readLine());
		for(l = 0; l < n; l++)
			a[l] = Integer.parseInt(st.nextToken());
		if(k == 0)
		{
			System.out.println(a[0]);
		}
		else
		{
			boolean end = false;
			l = 1; r = 2;size = 2;
			while(!end)
			{
				//System.out.println(l + "###" + r);
				if(l <= k && k <= r)
				{
					end = true;
					System.out.println(a[k-l]);
				}
				l = l + size;
				r = r + size + 1;
				size++;
			}
		}
			
	}
}
