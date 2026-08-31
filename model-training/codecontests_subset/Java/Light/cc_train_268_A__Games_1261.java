
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Cf268A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("/Users/ouda/eclipse-workspace/ACM2/src/txtin"));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		Point [] a = new Point[n];
		for(int i=0;i<n;i++) {
			String[] s = br.readLine().split(" ");
			a[i]=new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		int counter=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(j==i)
					continue;
				if(a[i].x==a[j].y)
					counter++;
			}
		}
		out.println(counter);
		out.flush();
	}
}
