import java.io.BufferedInputStream;
import java.util.Scanner;


public class A {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		while(input.hasNext())
		{
			int r1 = input.nextInt();
			int r2 = input.nextInt();
			int c1 = input.nextInt();
			int c2 = input.nextInt();
			int d1 = input.nextInt();
			int d2 = input.nextInt();
			int w,x = 0,y = 0,z = 0;
			boolean bFlag = false;
			for(w=1; w<=9; w++)
			{
				for(x=1; x<=9; x++)
				{
					
					for(y=1; y<=9; y++)
					{
						for(z=1; z<=9; z++)
						{
							if((r1==w+x)&&(r2==y+z)&&(c1==w+y)&&(c2==z+x)&&(d1==w+z)&&(d2==y+x))
							{
								bFlag = true;
								break;
							}
						}
						if(bFlag)
						{
							break;
						}
					}
					if(bFlag)
					{
						break;
					}
				}
				if(bFlag)
				{
					break;
				}
			}
			if((w>9)||(x>9)||(y>9)||(z>9)||(w==x)||(w==y)||(w==z)||(x==y)||(x==z)||(y==z))
			{
				System.out.println("-1");
			}else {
				System.out.println(w+" "+x+"\n"+y+" "+z);
			}
		}
		
	}
}
