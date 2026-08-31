import java.util.*;
import java.io.*;
import java.lang.*;



public class Codeforcecontest {

	int n,k,s,t;
	int arr[];


	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new
					InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException  e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}


	public static void main(String[] args) throws IOException {
		//Scanner s = new Scanner(System.in);
		Codeforcecontest con = new Codeforcecontest();
		con.run();

	}

	class pair{
		int price,fuel;
		public pair(int pr,int fl){
			price = pr;
			fuel = fl;
		}
	}
	private void run() {
		FastReader fr = new FastReader();
		n = fr.nextInt(); k = fr.nextInt(); s = fr.nextInt(); t = fr.nextInt();
		pair ax[] = new pair[n];
		for(int i=0;i<n;i++)
		{
			ax[i] = new pair(fr.nextInt(), fr.nextInt());
		}
		arr = new int[k+2];
		//		arr[0] = 0;
		//		arr[k+1] = s;
		for(int i=0;i<k;i++)
			arr[i] = fr.nextInt();
		arr[k] = 0;
		arr[k+1] = s;
		Arrays.sort(arr);

		int len = findcap();
		if(len==-1)
			System.out.println(-1);
		else{
			int price = Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				if(ax[i].fuel>=len)
					price = Math.min(price, ax[i].price);
			}

			System.out.println((price==Integer.MAX_VALUE)?-1:price);
		}
	}
	private int findcap() {
		int incap = 1;
		int finalcap = (int) (1e9 + 1);
		int ans = -1;
		while(incap<=finalcap)
		{
			int mid= (incap+finalcap)/2;
			if(check(mid))
			{
				ans = mid;
				finalcap = mid-1;
			}
			else
				incap = mid+1;
		}

		return ans;
	}
	private boolean check(int fuel) {

		boolean flag = true;
		int x = arr[0];
		int time = 0;
		for(int i=1;i<arr.length;i++)
		{
			int y = arr[i];
			int d = y-x;
			if(d>fuel)
			{
				flag = false;
				break;
			}

			int temp = 2*d;
			int remf = fuel - d;
			temp-=Math.min(remf, d);
			time+=temp;
			x = y;
		}
		if(!flag)
			return false;
		else
			return (time<=t)?true:false;
	}
}