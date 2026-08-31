import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cf1236a {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		while(tc-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int a1=a,b1=b,c1=c;
			int a2=a,b2=b,c2=c;
			int res1=0,res2=0;
			int ans1=0,ans2=0;
			{
				
				res1 = Math.min(a1, b1>>1);
				b1 -= Math.max(0, (res1<<1));
				res1 += Math.min(b1, c1>>1);
				
			}
			{
				res2 = Math.min(b2, c2>>1);
				b2-= res2;
				res2 += Math.min(a2, b2>>1);
			}
			out.println(Math.max(res1, res2)*3);
		}
		br.close();
		out.close();
	}
}
