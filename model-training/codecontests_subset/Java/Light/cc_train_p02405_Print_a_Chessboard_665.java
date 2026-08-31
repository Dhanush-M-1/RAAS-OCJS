
import java.util.Scanner;


public class Main {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		for(;;)
		{
			int w = scanner.nextInt();
			int h = scanner.nextInt();
			
			if(w==0 && h==0)
			{
				break;
			}
			
			for(int i=0; i<w; i++)
			{
				for(int j=0; j<h; j++)
				{
					if((i%2==0 && j%2==0) || (i%2==1 && j%2==1))
					{
						System.out.print("#");
					}
					else
					{
						System.out.print(".");
					}
				}
				System.out.println("");
			}
			System.out.println("");
		}
	}
}