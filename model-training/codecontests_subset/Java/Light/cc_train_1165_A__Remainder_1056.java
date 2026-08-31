import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		while (in.ready()) {
			StringTokenizer sb=new StringTokenizer(in.readLine());
			int n=Integer.parseInt(sb.nextToken());
			int x=Integer.parseInt(sb.nextToken());
			int y=Integer.parseInt(sb.nextToken());
			String s=in.readLine();
			int res=0;
			for (int i=n-x;i<n;++i) if (i==n-y-1&&s.charAt(i)!='1') ++res;
			else if (i!=n-y-1&&s.charAt(i)!='0') ++res;
			out.println(res);
		}
		out.flush();
	}
}