import java.util.Scanner;
public class Elections1043A
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		a[0] = sc.nextInt();
		int lar = a[0];
		int sm = a[0];
		for(int i=1;i<n;i++)
		{
			a[i] = sc.nextInt();
			sm = sm + a[i];
			if(a[i]>=lar)
				lar = a[i] ;
		}
		int sm1=0;
		for(int i=0;i<n;i++)
			sm1= sm1+(lar-a[i]);
		if(sm1>sm)
			System.out.println(lar);
		else
		{	
			while(sm1<=sm)
			{	sm1=0;
				lar++;
				for(int i=0;i<n;i++)
				sm1= sm1+(lar-a[i]);
			}
			System.out.println(lar);

		}
	}
}