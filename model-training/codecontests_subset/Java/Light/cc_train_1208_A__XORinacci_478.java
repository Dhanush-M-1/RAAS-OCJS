import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		in.nextToken();
		int t = (int) in.nval;
		long[] arr = new long[3];
		int n;
		while (t-- > 0)
		{
			in.nextToken();
			arr[0] = (long) in.nval;
			in.nextToken();
			arr[1] = (long) in.nval;
			in.nextToken();
			n = (int) in.nval;
			arr[2] = arr[0] ^ arr[1];
			pr.println(arr[n % 3]);
		}
		pr.flush();
		pr.close();
		br.close();
	}
}