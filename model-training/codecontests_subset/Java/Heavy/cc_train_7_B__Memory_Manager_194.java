import java.io.*;
public class Sevenb
{
	public static void main(String args[]) throws Exception
	{
		int t,m,no,case1;

		int memory[]=new int[102];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		String temp[]=line.split(" ");
		t=Integer.parseInt(temp[0]);
		m=Integer.parseInt(temp[1]);
		int i,pointer=0,x=1;
		int j=0,k;
		String command;
		// Allocating the memory to Nil
		for(i=1;i<=m;i++)
		{
			memory[i]=0;
		}
		for(case1=0;case1<t;case1++)
		{
		line=br.readLine();
		temp=line.split(" ");
		command=temp[0];
		if(command.equals("alloc"))
		{
			int count=0;
			no=Integer.parseInt(temp[1]);
			j=1;
			for(j=1;j<=m && count<no ;j++)
			{
				if(memory[j]!=0)
				{
					count=0;
				}
				else
				{
					count++;
				}
			}
		//	System.out.println("count "+count);
			if(count==no && no!=0)
			{
				for(k=count;k>0;k--)
				{
					memory[--j]=x;
				}

				System.out.println(x);
				x++;
			}
			else
			{
				System.out.println("NULL");
			}
		}
		else if(command.equals("erase"))
		{
			no=Integer.parseInt(temp[1]);
			if(no>x || no<=0)
			{
				System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else
			{
				int flag=0;
				for(j=1;j<=m;j++)
				{
					if(memory[j]==no)
					{
						memory[j]=0;
						flag=1;
					}
				}
				if(flag==0)
				System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
		}
		else
		{
			int flag=0;
			for(i=1;i<=m;i++)
			{
				if(memory[i]==0)
				{
					j=i;
					break;
				}
			}
		//System.out.println("j "+j);
			//j ->adress of first zero
			for(;i<=m;i++)
			{
				if(memory[i]!=0)
				break;
			}
		//	System.out.println("i "+i);
			for(;i<=m;i++)
			{
				if(memory[i]==0)
				continue;
				memory[j++]=memory[i];
				flag=1;
			}
if(flag==1)
{
			for(;j<=m;j++)
			{
				memory[j]=0;
			}
		}
		}
	/*for(i=1;i<=m;i++)
		{
			System.out.print(memory[i]+" ");
		}
		System.out.println();*/
		} 
	}
}