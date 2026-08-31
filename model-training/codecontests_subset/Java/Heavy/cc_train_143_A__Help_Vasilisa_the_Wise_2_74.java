import java.util.*;
import java.lang.*;
public class A143
	{
	public static void main(String[] args)
		{
		Scanner in = new Scanner(System.in);
		int r1 = in.nextInt();
		int r2 = in.nextInt();
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		int i=0,j=0,k=0,l=0;
		if(r1==1||r2==1||c2==1||c1==1||d1==1||d2==1)
			{
			System.out.println("-1");
			System.exit(0);
			}
		for(i=1;i<10;i++)
			{
			for(j=1;j<10;j++)
				{
				if(j!=i)
					{
					for(k=1;k<10;k++)
						{
						if(k!=i&&k!=j)
							{
							for(l=1;l<10;l++)
								{
								if(l!=i&&l!=j&&l!=k)
									{
									if(check(i,j,k,l,r1,r2,c1,c2,d1,d2))
										{
										System.out.println(i+" "+j+"\n"+k+" "+l);System.exit(0);
										}
									}
								}
							}
						}
					}
				}
			}
		System.out.println("-1");
		System.exit(0);
		}
	public static boolean check(int i,int j,int k,int l,int r1,int r2,int c1,int c2,int d1,int d2)
		{
		if(i+j==r1&&k+l==r2&&i+k==c1&&l+j==c2&&i+l==d1&&k+j==d2)
			{
			return true;
			}
		return false;
		}
	}
	