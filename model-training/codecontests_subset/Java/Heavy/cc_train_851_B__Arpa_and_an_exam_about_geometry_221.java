import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		final long ax = Long.parseLong(st.nextToken());
		final long ay = Long.parseLong(st.nextToken());
		final long bx = Long.parseLong(st.nextToken());
		final long by = Long.parseLong(st.nextToken());
		final long cx = Long.parseLong(st.nextToken());
		final long cy = Long.parseLong(st.nextToken());
		
		double D = 2*(ax*(by-cy) + bx*(cy-ay) + cx*(ay-by));
		if(D == 0){
			System.out.println("NO");
			System.exit(0);
		}
		double ox = ((ax*ax+ay*ay)*(by-cy) + (bx*bx+by*by)*(cy-ay) + (cx*cx+cy*cy)*(ay-by))/D;
		double oy = ((ax*ax+ay*ay)*(cx-bx) + (bx*bx+by*by)*(ax-cx) + (cx*cx+cy*cy)*(bx-ax))/D;
		
		double angle1 = (ax-ox)*(bx-ox) + (ay-oy)*(by-oy);
		double angle2 = (bx-ox)*(cx-ox) + (by-oy)*(cy-oy);
		
		//System.out.println(ox + " " + oy);
		//System.out.println(angle1 + "  " + angle2);
		
		if(Math.abs(angle1-angle2) < 1e-3) System.out.println("Yes");
		else System.out.println("No");

	}
}