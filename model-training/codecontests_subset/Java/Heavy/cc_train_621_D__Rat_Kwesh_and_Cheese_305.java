import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Div2_621D {
	public static double[] values;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble(), b = scan.nextDouble(), c = scan.nextDouble();
		
		values = new double[] {a,b,c};
		
		TriExp[] triExps = new TriExp[] { 
				new TriExp(0,1,2,false), new TriExp(0,2,1,false), new TriExp(0,1,2,true),
				new TriExp(1,0,2,false),new TriExp(1,2,0,false), new TriExp(1,0,2,true),
				new TriExp(2,0,1,false),new TriExp(2,1,0,false),new TriExp(2,0,1,true)
				};
		TriExp best = triExps[0];
		for(int i=1;i<triExps.length;i++) {
			TriExp him = triExps[i];
			int comp = him.compareTo(best);
			//System.out.println(him + " compareTo " + best + " = " + comp);
			if(comp > 0) {
				best = him;
				//System.out.println("New best = " + best);
			}
			//System.out.println();
		}
		System.out.println(best);
	}
}
class TriExp implements Comparable<TriExp> {
	public static double values[];
	double a,b,c;
	boolean isParen;
	private String form;
	public TriExp(int a, int b, int c, boolean isParen) {
		this.isParen = isParen;
		StringBuilder sb = new StringBuilder();
		if(isParen)
			sb.append('(');
		sb.append((char)(a+'x'));
		sb.append('^').append((char)(b+'x'));
		if(isParen)
			sb.append(')');
		sb.append('^').append((char)(c+'x'));
		this.form = sb.toString();
		this.a = Div2_621D.values[a];
		this.b = Div2_621D.values[b];
		this.c = Div2_621D.values[c];
	}
	public double eval() {
		double base = isParen ? Math.pow(a, b) : a;
		double exp = isParen ? c : Math.pow(b, c);
		return Math.pow(base,exp);
	}
	@Override
	public String toString() {
		return form;
	}
	public double log(double value) {
			return Math.log(value);
	}
	public double loglog(double value) {
		if(value > 1) {
			return log(log(value));
		}
		return -1e99;
	}
	public int compare(double a, double b) {
		if(Math.abs(a-b) < .0000000001)
			return 0;
		return Double.compare(a, b);
	}
	@Override
	public int compareTo(TriExp o) {
		if(this.a <= 3 && this.b <= 3 && this.c <= 3) {
			//System.out.println(this.eval() + " or " + o.eval());
			double left = this.eval();
			double right = o.eval();
			return compare(left,right);
		}
		if(!isParen && !o.isParen) {
			double lefta = c * log(b);
			double leftb = loglog(a);
			double righta = o.c * log(o.b);
			double rightb = loglog(o.a);
			if(leftb == -1e99 || rightb == -1e99)
				return Double.compare(leftb, rightb);
			return compare(lefta+leftb, righta+rightb);
		}
		if(isParen && !o.isParen) {
			double lefta = log(b) + log(c);
			double leftb = loglog(a);
			double righta = o.c * log(o.b);
			double rightb = loglog(o.a);
			//System.out.println("~" + (lefta+leftb) + " <?> " + (righta+rightb) + " = " + Double.compare(lefta+leftb, righta+rightb));
			if(leftb == -1e99 || rightb == -1e99)
				return compare(leftb, rightb);
			return compare(lefta+leftb, righta+rightb);
		}
		if(!isParen && o.isParen) {
			return -o.compareTo(this);
		}
		double left = b*c*log(a);
		double right = o.b*o.c*log(o.a);
		return compare(left,right);
		
		
	}
}
