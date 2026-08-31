
import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Main {

	int INF = 1 << 28;

	void run() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			P[] ps = new P[4];
			String[] vs = sc.next().split(",");
			for(int i=0;i<4;i++) ps[i] = new P( Double.parseDouble(vs[2*i]), Double.parseDouble(vs[2*i+1]) );
			
			System.out.println( ( cross(ps[0], ps[2], ps[1], ps[3])? "YES": "NO" ) );
		}
	}
	
	boolean cross(P p1, P p2, P q1, P q2) {
		return p1.sub(p2).det(q1.sub(p2)) * p1.sub(p2).det(q2.sub(p2)) < 0.0 &&
			   q1.sub(q2).det(p1.sub(q2)) * q1.sub(q2).det(p2.sub(q2)) < 0.0;
	}
	
	class P {
		double x, y;
		P(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		P sub(P p) {
			return new P(x-p.x, y-p.y);
		}
		
		double det(P p) {
			return x*p.y - p.x*y;
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
	}
}