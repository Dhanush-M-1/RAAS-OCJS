
import java.io.*;
import java.util.*;

public class B {
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		long xa = Long.parseLong(st.nextToken());
		long ya = Long.parseLong(st.nextToken());
		long xb = Long.parseLong(st.nextToken());
		long yb = Long.parseLong(st.nextToken());
		long xc = Long.parseLong(st.nextToken());
		long yc = Long.parseLong(st.nextToken());
		
		if((xa-xb)*(xa-xb)+(ya-yb)*(ya-yb)==(xc-xb)*(xc-xb)+(yc-yb)*(yc-yb) && (xa-xc)*(yb-yc)!=(xb-xc)*(ya-yc))
			System.out.println("Yes");
		else
			System.out.println("No");
		
		in.close();
	}

}
