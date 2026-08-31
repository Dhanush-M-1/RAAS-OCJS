import java.util.Scanner;

public class HelpVasilisaTheWise2_143A {
	
	static boolean unique (int a , int b , int c , int d)
	{
		
		return (a != b) && (c != a ) && (c != b) && (d != a) && (d != b) && (d != c);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int r1 = in.nextInt();
		int r2 = in.nextInt();
		
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		boolean found = false;
		int min = Math.min(d1, Math.min(r1, c1));
		min = Math.min(9, min);
		for (int i = 1 ; i <= min ; i++)
		{
			int r1c1 = i ;
			int r2c1 = c1 - i ; //== r2 - (d1-i)
			int r1c2 = r1 - i;
			int r2c2 = r2 - r2c1 ;
			boolean unique = unique (r1c1 , r2c1, r1c2, r2c2);
			if (r2 - r2c1 == c2 - r1c2 && unique && r2c1 > 0 && r1c2 > 0 && r2c2 > 0 && r2c1 < 10 && r1c2 < 10 && r2c2 < 10 )
			{
				if (d1 == r1c1 + r2c2 && d2 == r2c1 + r1c2 )
				{
					found = true;
					System.out.println(r1c1 + " " + r1c2);
					System.out.println(r2c1 + " " + r2c2);
				}
			}
		}
		if (!found ){System.out.println(-1);}

	}

}
