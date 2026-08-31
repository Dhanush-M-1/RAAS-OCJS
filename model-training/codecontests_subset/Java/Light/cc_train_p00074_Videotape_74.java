import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		for(; ;)
		{
			int t = scanner.nextInt();
			int h = scanner.nextInt();
			int s = scanner.nextInt();
			if(t==-1 && h==-1 && s==-1)
			{
				break;
			}
			int record = (t*3600 + h*60 + s);
			int time = 7200 - record;
			System.out.printf("%1$02d:%2$02d:%3$02d\n", time/3600, (time/60)%60, time%60);
			time *= 3;
			System.out.printf("%1$02d:%2$02d:%3$02d\n", time/3600, (time/60)%60, time%60);
		}
	}
}