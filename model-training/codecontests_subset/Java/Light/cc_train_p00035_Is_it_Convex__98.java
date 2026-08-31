import java.awt.geom.Line2D.Double;
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	in.useDelimiter("(\\p{javaWhitespace}|,)+");
	Double line1=new Double();
	Double line2=new Double();
	while (in.hasNext()) {
	 line1.x1=in.nextDouble();
	 line1.y1=in.nextDouble();
	 line2.x1=in.nextDouble();
	 line2.y1=in.nextDouble();
	 line1.x2=in.nextDouble();
	 line1.y2=in.nextDouble();
	 line2.x2=in.nextDouble();
	 line2.y2=in.nextDouble();
		System.out.println((line1.intersectsLine(line2))?"YES":"NO");
	}
 }
}