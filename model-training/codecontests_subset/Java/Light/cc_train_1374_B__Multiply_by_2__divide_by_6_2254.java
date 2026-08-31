import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main
{
	static BufferedReader br = null;
	static StreamTokenizer in = null;
	static PrintWriter pr = null;

	public static void main(String[] args) throws IOException
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		in = new StreamTokenizer(br);
		pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		in.nextToken();
		int t = (int) in.nval;
		int n;
		int ans;
		while (--t >= 0)
		{
			in.nextToken();
			n = (int) in.nval;
			ans = 0;
			while (n % 6 == 0)
			{
				n /= 6;
				ans++;
			}
			while (n % 3 == 0)
			{
				n /= 3;
				ans += 2;
			}
			if (n == 1)
			{
				pr.println(ans);
			}
			else
			{
				pr.println(-1);
			}
		}
		pr.flush();
		pr.close();
		br.close();
	}
}
