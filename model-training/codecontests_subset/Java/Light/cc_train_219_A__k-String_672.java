import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		String in = br.readLine();
		int[] alp = new int[26];
		String out = ""; 
		int res = 1;

		for(int i = 0; i < in.length(); i++)
			alp[in.charAt(i) - 'a']++;

		for(int i = 0; i < alp.length; i++)
			if(alp[i] % k != 0)
			{
				res = -1;
				break;
			}
		if(res == 1)
		{
			for(int i = 0; i < alp.length; i++)
			{
				if(alp[i] != 0)
					for(int j = 0; j < alp[i] / k; j++)
					{	
						out += (char)(i + 'a');
					}
			}
			String toOut = "";
			for(int j = 0; j < k; j++)
				toOut += out;
			System.out.println(toOut);
		}
		else
			System.out.println(res);



		br.close();
	}
}