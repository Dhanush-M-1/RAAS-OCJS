import java.util.*;
public class codeforces11
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int test=input.nextInt();
		for(int i=0;i<test;i++)
		{
			int count=0;
			int x=input.nextInt();
			int y=input.nextInt();
			int z=input.nextInt();
				if(y>=1 && z>=2)
				{			
						if(y>(z/2))
						{
							count=(z/2)*2+(z/2);
							y=y-z/2;
							z=0;
						}
						else
						{
							count=y+2*y;
							z=z-2*y;
							y=0;
						}			
				}
				if(x>=1 && y>=2)
				{
						if(x>(y/2))
							count=count+(y/2)*2+(y/2);
						else
							count=count+x+2*x;
				}
			
			

			System.out.println(count);

		}
	}
}