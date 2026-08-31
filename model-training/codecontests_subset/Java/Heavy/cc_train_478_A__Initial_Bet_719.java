import java.util.Scanner;
public class A_478 {
	private static Scanner tec = new Scanner(System.in);
	public static void main(String[] args) {
		int [] a = new int[5];
		for(int i = 0; i < a.length; i++)
			a[i] = tec.nextInt();
		ordenamiento(a);
		
		boolean p = true;
		while (p)
		{
			int c = 0;
			for(int i = 0; i < a.length - 1; i++)
				if (a[i] > a[i+1])
				{
					a[i]--;
					a[i+1]++;
					c++;
				}
			if (c == 0)
				p = false;
		}
		
		boolean o = true;
		
		for(int i = 0; i < a.length - 1; i++)
			if (a[i] != a[i + 1] || a[i] == 0)
				o = false;
		if (o)
			System.out.println(a[0]);
		else
			System.out.println("-1");
	}
	static void ordenamiento(int [] a)
	{
		int temporal;
		boolean p = true;
		while (p)
		{
			int c = 0;
			for(int i = 0; i < a.length - 1; i++)
				if (a[i] < a[i+1])
				{
					temporal = a[i];
					a[i] = a[i+1];
					a[i+1] = temporal;
					c++;
				}
			if (c == 0)
				p = false;
		}
	}

}
