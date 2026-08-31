import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			int h1 = sc.nextInt(),
				m1 = sc.nextInt(),
				s1 = sc.nextInt();
			if (h1 == -1 && m1 == -1 && s1 == -1) break;
			int h = 2, m = 0, s = 0;
			s -= s1;
			if (s < 0)
			{
				s += 60;
				m--;
			}
			m -= m1;
			if (m < 0)
			{
				m += 60;
				h--;
			}
			h -= h1;
			System.out.printf("%02d:%02d:%02d\n", h, m , s);
			h *= 3;
			m *= 3;
			h += m / 60;
			m = m % 60;
			s *= 3;
			m += s / 60;
			s = s % 60;
			System.out.printf("%02d:%02d:%02d\n", h, m , s);
		}
	}
}