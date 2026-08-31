import java.util.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;

// AOJ 0035
public class Main {

	static Scanner sc = new Scanner(System.in);
	static final double EPS = 1e-10;
	public static void main(String[] args) {
		while (sc.hasNext()) {
			String[] buf = sc.next().split(",");
			Complex[] cs = new Complex[4];
			for (int i = 0; i < 4; i++) 
				cs[i] = new Complex(Double.valueOf(buf[i * 2]), Double.valueOf(buf[i * 2 + 1]));
			if (Complex.isConvex(cs)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

class Complex {
	static final double EPS = 1e-10;
	
	double re, im;
	
	Complex (double r, double i) {
		re = r; im = i;
	}

	double arg() {
		return Math.atan2(im, re);
	}
	
	double abs2() {
		return re * re + im * im;
	}
	
	double abs() {
		return Math.sqrt(abs2());
	}
	
	double innerProdut(Complex o) {
		return re * o.re + im * o.im;
	}
	
	double crossProduct(Complex o) {
		return re * o.im - im * o.re;
	}
	
	static Complex polar(double theta, double r) {
		return new Complex(r * Math.cos(theta), r * Math.sin(theta));
	}
	
	Complex conj() {
		return new Complex(re, -im);
	}
	
	Complex add(Complex o) {
		return new Complex(re + o.re, im + o.im);
	}

	Complex sub(Complex o) {
		return new Complex(re - o.re, im - o.im);
	}
	
	Complex mul(Complex o) {
		return new Complex(re * o.re - im * o.im, re * o.im + im * o.re);
	}
	
	Complex div(Complex o) {
		return new Complex((re * o.re + im * o.im) / o.abs2(), (im * o.re - re * o.im) / o.abs2());
	}

	static int ccw(Complex a, Complex b, Complex c) {
		b = b.sub(a); c = c.sub(a);
		if (b.crossProduct(c) > 0) 	return +1;	// counter clockwise
		if (b.crossProduct(c) < 0) 	return -1;	// clockwise
		if (b.innerProdut(c) < 0) 	return +2;	// c--a--b on line
		if (b.abs() < c.abs())		return -2;	// a--b--c online
		return 0;
	}
	
	static boolean isConvex(Complex[] cs) {
		int size = cs.length, d = ccw(cs[(size + 0 - 1) % size], cs[0], cs[(0 + 1) % size]);
		for (int i = 1; i < size; i++) {
			
			if (ccw(cs[(size + i - 1) % size], cs[i], cs[(i + 1) % size]) * d < 0) return false;
			
		}
		return true;
	}
}