import java.io.*;
import java.util.*;

public class Main
{ 

	public static void main(String[] args)
	throws Exception
	{ 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		StringTokenizer sz = new StringTokenizer(reader.readLine());

		int sum=0;

		for (int i=1;i <= 5;++i)
			sum += Integer.parseInt(sz.nextToken());

		if (sum % 5 == 0 && sum != 0)
			writer.print(sum / 5);
		else
			writer.print(-1);

		writer.flush();
	} 

}
