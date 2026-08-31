
import java.awt.Point;
import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c {
	public static void main(String[] args) {
		MyScanner scan = new MyScanner();
		int n = scan.nextInt();
		Point center = new Point(scan.nextInt(), scan.nextInt());
		Point[] list = new Point[n];
		double minDist = Integer.MAX_VALUE, maxDist = Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			list[i]=new Point(scan.nextInt(), scan.nextInt());
		}
		for(int i=0;i<n;i++){
			Line2D.Double line = new Line2D.Double(list[i],list[(i+1)%n]);
			double dist = line.ptSegDist(center);
			double dist2 = list[i].distance(center);
			minDist = Math.min(minDist, Math.min(dist, dist2));
			maxDist = Math.max(maxDist, Math.max(dist, dist2));
		}
		double area = Math.PI*(maxDist*maxDist-minDist*minDist);
		
		System.out.println(area);

	}
	
	private static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
