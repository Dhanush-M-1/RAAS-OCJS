import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader tec=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		StringTokenizer st=new StringTokenizer(tec.readLine());
		String a=st.nextToken();
		String b=st.nextToken();
		out.println(a+" "+b);
		int n=Integer.parseInt(tec.readLine().trim());
		for (int i = 0; i < n; i++) {
			st=new StringTokenizer(tec.readLine());
			String s=st.nextToken();
			if(s.equals(a))
				a=st.nextToken();
			else
				b=st.nextToken();
			out.println(a+" "+b);
		}
		out.close();
	}
}