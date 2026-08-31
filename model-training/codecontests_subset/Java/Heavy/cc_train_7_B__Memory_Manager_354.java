import java.util.* ;
public class Main
{
	public static void main(String [] args)
	{
		Scanner s=new Scanner (System.in);
		int  t=s.nextInt(), m=s.nextInt(),i,j,cnt=1;
		s.nextLine();
		int  [] a=new int[m+5];
		for(int cas=0;cas<t;cas++)
		{
			String []temp=s.nextLine().split(" ");
			if(temp[0].charAt(0)=='a')
			{
				int len=Integer.valueOf(temp[1]);
				boolean flag=true ;
				for(i=1;i<=m;i++)
				{
					flag=true ;
					for(j=i;j<len+i;j++)
					{
						if(a[j]!=0||j>m)
						{
							flag=false ;
							break ;
						}
					}
					if(flag)  break ;
				}
				if(flag)
				{
					for(j=i;j<len+i;j++)  a[j]=cnt;
					System.out.println(cnt++);
				}
				else  System.out.println("NULL");
			}
			else  if(temp[0].charAt(0)=='e')
			{
				int len=Integer.valueOf(temp[1]);
				boolean flag=false ;
				for(i=1;i<=m;i++)
				{
					if(a[i]==len)
					{
						a[i]=0;
						flag=true ;
					}
				}
				if(!flag||len==0)  System.out.println("ILLEGAL_ERASE_ARGUMENT");
			}
			else 
			{
				int []c=new int[m+5];
				int num=1;
				for(i=1;i<=m;i++)
				{
					if(a[i]!=0)
					{
						c[num++]=a[i];
						a[i]=0;
					}
				}
				for(i=1;i<=m;i++)  a[i]=c[i];
			}
		}
		s.close();
	}
}

