import java.util.*;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

public class B {
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		int x = 0, y = 0, n, z = 0;
		int[] f = new int[105];
		String s;
		char c1, c2;
		for (;;)
		{
			s = cin.next();
			c1 = s.charAt(0);
			s = cin.next();
			c2 = s.charAt(0);
			if (c2 == '=') break;
			z++;
			if (c2 == '+')
			{
				x++;
				f[z] = 1;
			}
			else
			{
				y++;
				f[z] = 0;
			}
		}
		n = cin.nextInt();
//		System.out.println(x + " " + y + " " + n);
		int ok = 1;
		if ((x + 1) * n - y < n) ok = 0;
		if (x + 1 - y * n > n) ok = 0;
		if (ok == 0)
			System.out.println("Impossible");
		int[] a = new int[105];
		int[] b = new int[105];
		if (ok == 1)
		{
			System.out.println("Possible");
			for (int i = 1; i <= x + 1; i++)
				a[i] = n;
			for (int i = 1; i <= y; i++)
				b[i] = 1;
			int ans = (x + 1) * n - y;
			for (int i = 1; i <= y; i++)
			{
				if (ans - (n - 1) > n)
				{
					b[i] = n;
					ans -= n - 1;
				}
				else
					while (ans != n)
					{
						b[i]++;
						ans--;
					}
			}
			for (int i = 1; i <= x + 1; i++)
			{
				if (ans - (n - 1) > n)
				{
					a[i] = 1;
					ans -= n - 1;
				}
				else
					while (ans != n)
					{
						a[i]--;
						ans--;
					}
			}
			int x1 = 1, x2 = 0;
			System.out.print(a[1] + " ");
			for (int i = 1; i <= z; i++)
				if (f[i] == 1)
				{
					x1++;
					System.out.print("+ " + a[x1] + " ");
				}
				else 
				{
					x2++;
					System.out.print("- " + b[x2] + " ");
				}
			System.out.println("= " + n);
		}
	}
}
