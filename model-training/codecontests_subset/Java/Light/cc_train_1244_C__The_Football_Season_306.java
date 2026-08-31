import java.util.Scanner;

public class z {

	public static void main(String[] args) 
	{
		Scanner cin= new Scanner(System.in);
		long n=cin.nextLong();
		long p=cin.nextLong();
		long w=cin.nextLong();
		long d=cin.nextLong();
		if(n*w<p||(p<d&&p!=0))
		{
			System.out.println("-1");
		}
		else
		{
			long z=p/w;
			long i=z*w;
			long wins=z;
			long draw=0;
			int flag=0;
			while(i>=0)
					{
						if(i==p)
						{
							break;
						}
						else
						{
							long j=i;
							if((p-j)%d==0)
							{
									draw+=(p-j)/d;
									break;
							}	
							else
							{
								if(w%d==0)
								{
									flag=1;
									break;
								}
								i=i-w;
								wins--;
							}
						}
					}
			if(flag==1)
			{
				System.out.println("-1");
			}
			else
			{
			System.out.println(wins+" "+draw+" "+ (n-wins-draw) );
			}	
			}
		}
}
