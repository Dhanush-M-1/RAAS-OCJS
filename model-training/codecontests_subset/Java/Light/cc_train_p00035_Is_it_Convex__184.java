import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String tmp = br.readLine();
			
			if(tmp == null){
				break;
			}
			
			String[] tmpArray = tmp.split(",");
			Point[] points = new Point[4];
			
			for(int i = 0; i < 4; i++){
				points[i] = new Point((int)(Double.parseDouble(tmpArray[i*2])*100000), (int)(Double.parseDouble(tmpArray[i*2+1])*100000));
			}
			
			boolean convex = false;
			for(int i = 0; i < 4; i++){
				Polygon triangle = new Polygon();
				for(int j = i; j < i + 4 ; j++){
					if(j%4 != (i + 2)%4){
						//System.out.println("add "+j%4);
						triangle.addPoint(points[j%4].x, points[j%4].y);
					}
				}
				if(triangle.contains(points[(i+2)%4])){
					convex = true;
					break;
				}
			}
			if(convex){
				System.out.println("NO");
			}
			else{
				System.out.println("YES");
			}
		}
	}

}