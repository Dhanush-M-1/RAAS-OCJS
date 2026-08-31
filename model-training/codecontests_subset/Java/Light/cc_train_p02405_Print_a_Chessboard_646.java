import java.util.Scanner;
public class Main
{
	public static void main( String args[] )
	{
		Scanner input = new Scanner(System.in);
		int h, w;
		while(true)
		{
			h=input.nextInt();
			w=input.nextInt();
			if(h == 0 && w == 0)
				break;
			else {
				for(int i = 0; i < h; i++)
				{
					for(int k = 0; k < w; k++)
					{
						if((i+k)%2==0)
							System.out.print("#");
						else
							System.out.print(".");
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}
}