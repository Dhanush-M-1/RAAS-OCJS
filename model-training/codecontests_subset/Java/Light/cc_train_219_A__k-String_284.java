import java.io.*;
import java.util.*;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()), i;
		String str = br.readLine();
		br.close();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		int len = str.length();
		for(i = 0; i < len; i++)
		{
			char ch = str.charAt(i);
			if(hm.containsKey(ch))
				hm.put(ch, hm.get(ch)+1);
			else
				hm.put(ch, 1);
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringBuilder unit = new StringBuilder();
		Set<Character> chars = hm.keySet();
		for(char ch : chars)
		{
			int freq = hm.get(ch), num = freq/k;
			if(freq%k != 0)
			{
				pw.println(-1);
				pw.close();
				System.exit(0);
			}
			for(i = 1; i <= num; i++)
				unit.append(ch);
		}
		for(i = 1; i <= k; i++)
			pw.print(unit);
		pw.close();
	}
}