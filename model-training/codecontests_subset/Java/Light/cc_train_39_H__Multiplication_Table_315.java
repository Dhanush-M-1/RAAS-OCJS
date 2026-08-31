import java.util.Scanner;
import java.lang.Math;
public class Ishu
{
    	public static void main(String[] args)
    	{
	 Scanner scan=new Scanner(System.in); 
	 int k,i,j,no,e,tem;
	 k=scan.nextInt();
	 for(i=1;i<k;++i)
		{
		 for(j=1;j<k;++j)
			{
			 no=i*j;
			 e=0;
			 tem=0;
			 while(no>0)
				{
				 tem+=(int)Math.pow(10.0,(double)e)*(no%k);
				 ++e;
				 no/=k;
				}
			 System.out.print(tem+" ");
			}
		 System.out.println();
		}
 	}
}