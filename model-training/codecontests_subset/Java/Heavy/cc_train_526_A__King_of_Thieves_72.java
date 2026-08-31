import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Codeforces531A {
	public static void main(String[] args) {
		try
		{
			BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(f.readLine());
			String s = f.readLine();
			char[] level = s.toCharArray();
			if(n < 5)
				System.out.println("no");
			else
			{
				boolean canMakeJump = false;
				for(int i = 0; i < n; i++)
				{
					//if(level[i] == '.')
					//	continue;
					for(int j = 1; j < n; j++)
					{
						int position = i;
						int count = 0;
						while(position < n && level[position] == '*' && count < 5)
						{
							position += j;
							count++;
						}
						if(count == 5)
						{
							canMakeJump = true;
							break;
						}
					}
					if(canMakeJump)
						break;
				}
				if(canMakeJump)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}

	}

}
