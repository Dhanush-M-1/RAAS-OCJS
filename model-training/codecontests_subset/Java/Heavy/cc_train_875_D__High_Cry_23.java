import java.io.*;
import java.util.*;
public class Main
{
	
	private void solve()throws Exception
	{
		int n=nextInt();
		int a[]=new int[n+1];
		for(int i=1;i<=n;i++)
			a[i]=nextInt();

		//leftmax[i] is the largest L such that a[L]>=a[i] and L<i
		int leftmax[]=new int[n+1];
		//rightmax[i] is the smallest R such that a[R]>a[i] and R>i
		int rightmax[]=new int[n+1];

		Stack<Integer> stack=new Stack<>();
		for(int i=1;i<=n;i++)
		{
			while(!stack.isEmpty())
			{
				if(a[stack.peek()]<a[i])
					stack.pop();
				else
					break;
			}
			leftmax[i]=stack.isEmpty()?0:stack.peek();
			stack.push(i);
		}
		stack.clear();
		for(int i=n;i>=1;i--)
		{
			while(!stack.isEmpty())
			{
				if(a[stack.peek()]<=a[i])
					stack.pop();
				else
					break;
			}
			rightmax[i]=stack.isEmpty()?n+1:stack.peek();
			stack.push(i);
		}

		//leftmask[i] is the largest L such that a[L] has a set bit not in a[i]
		int leftmask[]=new int[n+1];
		//rightmask[i] is the smallest R such that a[R] has a set bit not in a[i]
		int rightmask[]=new int[n+1];

		int recent[]=new int[30];
		Arrays.fill(recent,0);
		Arrays.fill(leftmask,0);
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<30;j++)
				if(((a[i]>>j)&1)==0)
					leftmask[i]=Math.max(leftmask[i],recent[j]);
				else
					recent[j]=i;
		}

		Arrays.fill(recent,n+1);
		Arrays.fill(rightmask,n+1);
		for(int i=n;i>=1;i--)
		{
			for(int j=0;j<30;j++)
				if(((a[i]>>j)&1)==0)
					rightmask[i]=Math.min(rightmask[i],recent[j]);
				else
					recent[j]=i;
		}

		long ans=0;
		for(int i=1;i<=n;i++)
		{
			ans+=1l*(i-Math.max(leftmax[i]+1,leftmask[i]+1)+1)*(Math.min(rightmax[i]-1,rightmask[i]-1)-i+1);
			ans--;
		}
		out.println(1l*n*(n-1)/2-ans);
	}

	 
	///////////////////////////////////////////////////////////

	public void run()throws Exception
	{
		br=new BufferedReader(new InputStreamReader(System.in));
		st=null;
		out=new PrintWriter(System.out);

		solve();
		
		br.close();
		out.close();
	}
	public static void main(String args[])throws Exception{
		new Main().run();
	}
	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	String nextToken()throws Exception{
		while(st==null || !st.hasMoreTokens())
		st=new StringTokenizer(br.readLine());
		return st.nextToken();
	}
	String nextLine()throws Exception{
		return br.readLine();
	}
	int nextInt()throws Exception{
		return Integer.parseInt(nextToken());
	}
	long nextLong()throws Exception{
		return Long.parseLong(nextToken());
	}
	double nextDouble()throws Exception{
		return Double.parseDouble(nextToken());
	}
}