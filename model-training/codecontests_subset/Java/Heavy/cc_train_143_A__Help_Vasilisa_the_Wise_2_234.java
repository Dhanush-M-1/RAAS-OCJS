import java.util.Scanner;
public class Ishu
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int r1,r2,c1,c2,d1,d2,i=0,j=0,k=0,l=0;
	boolean flag=false;
	int[] gems=new int[]{1,2,3,4,5,6,7,8,9};
	r1=scan.nextInt();
	r2=scan.nextInt();
	c1=scan.nextInt();
	c2=scan.nextInt();
	d1=scan.nextInt();
	d2=scan.nextInt();
	for(i=0;i<9;++i)
		{
		for(j=0;j<9;++j)
			{
			if(!(gems[i]==gems[j])&&gems[i]+gems[j]==r1)
				{
				for(k=0;k<9;++k)
					{
					if(!(gems[i]==gems[k])&&!(gems[j]==gems[k])&&gems[i]+gems[k]==c1&&gems[j]+gems[k]==d2)
						{
						for(l=0;l<9;++l)
							{
							if(!(gems[i]==gems[l])&&!(gems[j]==gems[l])&&!(gems[k]==gems[l])&&gems[k]+gems[l]==r2&&gems[i]+gems[l]==d1&&gems[j]+gems[l]==c2)
								{
								flag=true;
								break;
								}    
							}
						}
					if(flag)		
						break;
					}
				}
			if(flag)
				break;
			}
		if(flag)
			break;
		}
	if(flag)
		{
		System.out.println(gems[i]+" "+gems[j]);
		System.out.println(gems[k]+" "+gems[l]);
		}
	else
		System.out.println(-1);
	}
}