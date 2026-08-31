import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Temp3 {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int req = (int) Math.ceil(y*n/100.0);
		out.append(Math.max(0, req-x)+"");
		out.flush();
	}
}
