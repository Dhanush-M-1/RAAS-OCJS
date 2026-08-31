import java.io.*;
import java.util.*;

public class chat {
	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		//InputStream input = new FileInputStream("fileIn.in");
		OutputStream output = System.out;
		//OutputStream output = new FileOutputStream("fileOut.out");
		br = new BufferedReader(new InputStreamReader(input));
		out = new PrintWriter(output);
		int tot_online = 0;
		String a;
		int tot = 0;
		while ((a = br.readLine()) != null)
			{
			if (a.charAt(0) == '+')
				tot_online++;
			else if (a.charAt(0) == '-')
				tot_online--;
			else
				{
				int start = 0;
				while (a.charAt(start) != ':')
					start++;
				start++;
				tot += tot_online * (a.length() - start);
				}
			}
		out.println(tot);
		out.close();
	}
}