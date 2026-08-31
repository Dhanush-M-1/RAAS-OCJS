import java.util.Scanner;


public class B
{

	public static void main(String[] args)
	{
		new B();
	}
	
	B()
	{
		Scanner in = new Scanner(System.in);
		int c=in.nextInt();
		int N=in.nextInt();
		int blockNum=1;
		
		int[] data = new int[N];
		while (c-->0)
		{
			String cmd=in.next();
			if (cmd.equals("alloc"))
			{
				int b=in.nextInt();
				int p=find(data,b);
				if (p==-1)
					System.out.println("NULL");
				else
				{
					System.out.println(blockNum);
					for (int i=p; i<p+b; ++i)
						data[i]=blockNum;
					++blockNum;
				}
			}
			else if (cmd.equals("erase"))
			{
				int b=in.nextInt();
				boolean did=false;
				for (int i=0; i<N; ++i)
					if (data[i]==b)
					{
						data[i]=0;
						did=true;
					}
				if (b<1 || b>=blockNum || !did)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else if (cmd.equals("defragment"))
			{
				defrag(data);
			}
		}
	}
	
	int find(int[] data, int len)
	{
		int free=0;
		for (int p=0; p<data.length; ++p)
		{
			if (data[p]==0)
				++free;
			else
				free=0;
			if (free==len)
				return p-len+1;
		}
		return -1;
	}
	
	void defrag(int[] data)
	{
		int[] ndata = new int[data.length];
		int p=0;
		for (int i=0; i<data.length; ++i)
			if (data[i]>0)
				ndata[p++]=data[i];
		System.arraycopy(ndata, 0, data, 0, data.length);
	}

}
