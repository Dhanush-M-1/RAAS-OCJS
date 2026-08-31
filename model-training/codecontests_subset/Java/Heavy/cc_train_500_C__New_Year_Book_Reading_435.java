import java.util.*;
import java.io.*;
public class New_Year_Book_Reading
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(f.readLine());
		int size=Integer.parseInt(st.nextToken());
		int runs=Integer.parseInt(st.nextToken());
		int[] arr=new int[size];
		st=new StringTokenizer(f.readLine());
		for(int x=0;x<size;x++)
			arr[x]=Integer.parseInt(st.nextToken());
		boolean[] used=new boolean[size];
		int[] order=new int[runs];
		Stack<Integer> stack=new Stack<Integer>();
		st=new StringTokenizer(f.readLine());
		for(int x=0;x<runs;x++)
		{
			order[x]=Integer.parseInt(st.nextToken())-1;
			if(!used[order[x]])
				stack.push(order[x]);
			used[order[x]]=true;
		}
		Collections.reverse(stack);
		int tot=0;
		for(int x=0;x<runs;x++)
		{
			int temp=order[x];
			Stack<Integer> stack1=new Stack<Integer>();
			while(stack.peek()!=temp)
			{
				int tempo=stack.pop();
				tot+=arr[tempo];
				stack1.push(tempo);
			}
			stack.pop();
			while(!stack1.isEmpty())
				stack.push(stack1.pop());
			stack.push(order[x]);
		}
		System.out.println(tot);
	}
}