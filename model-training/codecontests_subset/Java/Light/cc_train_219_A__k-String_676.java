import java.util.*;

public class kstring {
	public static void main(String[] args)	{
		Scanner in = new Scanner(System.in);
		int k = Integer.parseInt(in.nextLine());
		String s = in.nextLine();
		int[] chars = new int[26];
		for (int i = 0; i < 26; i++)
			chars[i] = 0;
		for (int i = 0; i < s.length(); i++)
			chars[s.charAt(i)-97] += 1;
		boolean possible = true;
		for (int i = 0; i < 26; i++)
			if (chars[i]%k != 0)
				possible = false;
		if (possible)	{
			for (int i = 0; i < 26; i++)
				chars[i] /= k;
			for (int i = 0; i < k; i++)
				for (int j = 0; j < 26; j++)
					for (int l = 0; l < chars[j]; l++)
						System.out.print((char)(j+97));
		}
		else
			System.out.println(-1);
	}
}
