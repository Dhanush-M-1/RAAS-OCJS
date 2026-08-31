import java.util.Scanner;
public class Gard 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int fin = 0;
		for(int i=0;i<n;i++)
		{
			int a = sc.nextInt();
			if(k%a == 0 && a>fin)
				fin = a;
		}
		System.out.println(k/fin);
	}
}