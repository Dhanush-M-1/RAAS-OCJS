import java.util.*;
import java.io.*;


public class MistManager implements Runnable
{

	int t,m;
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	String operation;
	int operand;
	int[] memmap;
	int[] memmap_cpy;
	int currId,ans;

	public MistManager()
	{	
		currId = 0;
	}

	public static void main(String args[])
	{
		new Thread(new MistManager()).start();
	}

	public void run()
	{
		read();
	}

	void read()
	{
		t = in.nextInt();
		m = in.nextInt();
		int i;
		memmap = new int[m];
		for(i=0;i<t;i++)
		{
			operation = in.next();
			if(operation.equals("defragment"))
			{
				solve();
			}
			else
			{
				operand = in.nextInt();
				solve();
			}
		}
		out.close();
	}

	void solve()
	{

		if (operation.equals("alloc") == true)
		{

			int i,start;
			for(start = 0;start<=m-operand;start++)
			{
				int j;

				for(j=start;j<start+operand;j++)
				{
					if(memmap[j]!=0){
						break;
					}
				}
				
				if(j == start+operand)
				{
					currId++;
					for(j=start;j<start+operand;j++)
					{
						memmap[j] = currId;
					}
					out.println(currId);
					break;	
				}
			}

			if(start > m-operand)
			{
				out.println("NULL");
			}
		
		}

		else if(operation.equals("erase"))
		{
			if(operand > currId || operand==0)
			{
				out.println("ILLEGAL_ERASE_ARGUMENT");
				return;
			}

			int start,j;
			for(start = 0;start<m;start++)
			{
				if(memmap[start] == operand)
				{
					j = start;
					while(j<m && memmap[j] == operand)
					{
						memmap[j] = 0;
						j++;
					}
					break;
				}
			}

			if(start >= m)
			{
				out.println("ILLEGAL_ERASE_ARGUMENT");
				return;
			}

		}

		else
		{
			int i;
			int k=0;
			memmap_cpy = new int[m];
			for(i=0;i<m;i++)
			{
				if(memmap[i] != 0)
				{
					memmap_cpy[k++] = memmap[i];
				}
			}
			memmap = memmap_cpy;
		}
	}

}