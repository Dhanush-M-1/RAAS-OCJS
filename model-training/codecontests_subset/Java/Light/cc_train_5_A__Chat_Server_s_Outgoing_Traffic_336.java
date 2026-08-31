import java.util.*;

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner cin = new Scanner(System.in);
		String str;
		int num = 0;// 记录在线人数
		int sum = 0;// 记录最终字节数
		int ans = 0;;// 记录冒号的位置
		while (cin.hasNext())
		{
			str = cin.nextLine();
			if (str.charAt(0) == '+')
				num++;
			else if (str.charAt(0) == '-')
				num--;
			else
			{
				for (int i = 0; i < str.length(); i++)
				{
					if (str.charAt(i) == ':')
					{
						ans = i;
						break;
					}
				}
				sum += (str.length() - 1 - ans) * num;
			}
		}
		System.out.println(sum);
		cin.close();

	}

}