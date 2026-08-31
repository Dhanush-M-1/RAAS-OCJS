import java.util.*;

public class Main {
	public static int blocks=0;
	public static int[] a=new int[10001];
	public static int m=0;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		m=s.nextInt();
		int[] t=new int[n];
		for(int i=0;i<n;i++)
		{
			String str=s.next();		
			if(str.equals("alloc"))
			{
				int pos=s.nextInt();
				String tem=s.nextLine();
				if(tem.length()>1)
				{
					t[i]=Integer.valueOf(tem.trim());
				}		
				else					
				{
					t[i]=pos;
					pos=0;
				}
				if(pos==0)
				{
					if(alloc(t[i])!=0)
					{
						System.out.println(blocks);
					}	
					else
						System.out.println("NULL");
				}
				else
				{
					if(alloc(pos,t[i])!=0)
					{
						System.out.println(blocks);
					}	
					else
						System.out.println("NULL");
				}
			}
			else if(str.equals("erase"))
			{
				t[i]=s.nextInt();
				s.nextLine();
				if(t[i]>n)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				else
				{
					if(erase(t[i])==-1)
						System.out.println("ILLEGAL_ERASE_ARGUMENT");
					else
						erase(t[i]);
				}
								
			}
			else
			{
				defragment();
				s.nextLine();
			}
		}
		s.close();
	}
	static int alloc(int x)
	{
		for(int i=0;i<m;i++)
		{
			int j=i;
			int num=0;
			while(a[j]==0&&num!=x&&j<m)
			{
				num++;
				j++;
			}
			if(num!=x)
				i=j;
			else
			{
				blocks++;
				for(int k=i;k<j;k++)
					a[k]=blocks;
				return blocks;
			}
		}
		return 0;	
	}

	static int alloc(int pos,int x)
	{
		int j=pos;
		int num=0;
		if(a[j]!=0)
			return 0;
		else
		{
			while(a[j]==0&&num!=x&&j<m)
			{
				num++;
				j++;
			}
			if(num!=x)
				return 0;
			else
			{
				blocks++;
				for(int k=pos;k<j;k++)
					a[k]=blocks;
				return blocks;
			}
		}				
	}
	
	static int erase(int x)
	{
		if(x<=0)
			return -1;
		int flag=0;
		for(int i=0;i<m;i++)
		{
			while(a[i]==x)
			{
				a[i++]=0;
				flag=1;
			}
		}
		if(flag==1)
			return -2;
		return -1;
	}
	static void defragment()
	{
		for(int i=0;i<m;i++)
		{
			if(a[i]==0)
			{
				for(int j=i+1;j<m;j++)
				{
					if(a[j]!=0)
					{
						a[i]=a[j];
						a[j]=0;
						break;
					}					
						
				}
			}
		}
		
	}
}