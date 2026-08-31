import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {new Main();}

	public Main() throws Exception {
		Scanner s = new Scanner(System.in);

		//circumcenter of a triangle exists as long as the points are not collinear
		//a circle with the center being the circumcenter passes through the three
		//points of a triangle.
		//now as long as the distance along the arc between a and b is equal to the distance
		//along the arc between b and c, the answer is yes.
		//you can form an isosceles triangle between any two points on a circle where the unequal
		//side is equal to the euclidean distance between the two points. You need equal isosceles
		//triangles in order to make sure that the points a ends up at b and b ends up at c.
		//Since the isosceles triangle depends on the distance between the two points, if the 
		//distance between a and b is not equal to the distance between b and c, the answer is no.
		
		long x1 = s.nextLong();
		long y1 = s.nextLong();
		long x2 = s.nextLong();
		long y2 = s.nextLong();
		long x3 = s.nextLong();
		long y3 = s.nextLong();

		String answer = "Yes";
		
		if((y2 - y1) * (x3 - x1) == (x2 - x1) * (y3 - y1)) {
			answer = "No";
		}
		
		if((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) != (x3-x2)*(x3-x2) + (y3-y2)*(y3-y2)) {
			answer = "No";
		}
		
		System.out.println(answer);

	}
}

