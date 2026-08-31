
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
public class bs {	

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken());
			int r=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			if(d<l || d>r) {
				pw.println(d);
			}
			else {
				pw.println(r-(r%d)+d);
			}
		}
		
		
		
		pw.close();
		pw.flush();

	}


}
