import java.awt.geom.Line2D;
import java.util.*;
public class Main {

	public void doIt(){
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("[,\\r\\n]+");
		while(sc.hasNext()){
			double [] data = new double[8];
			for(int i=0; i < 8; i++)
				data[i] = sc.nextDouble();
			Line2D.Double ac = new Line2D.Double(data[0], data[1], data[4], data[5]);
			Line2D.Double bd = new Line2D.Double(data[2], data[3], data[6], data[7]);
			if(ac.intersectsLine(bd))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}
	public static void main(String[] args) {
		Main obj = new Main();
		obj.doIt();

	}

}