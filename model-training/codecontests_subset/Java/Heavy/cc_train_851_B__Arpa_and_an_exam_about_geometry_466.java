import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
	public static <T> void test(T t){
		System.out.println(t);
	}
	public static <T,T2> void test(T t,T2 t2){
		System.out.println(t + " " + t2);
	}
	public static <T,T2,T3> void test(T t,T2 t2,T2 t3){
		System.out.println(t + " " + t2 + " " + t3);
	}
	int n;
	int k;
	int t;
	static BigDecimal eps = new BigDecimal(1e-90);
	static class NODE{
		BigDecimal x,y;
		NODE(){}
	}
	static NODE[] p = new NODE[4];
	static BigDecimal k(NODE a,NODE b){
		if(eq(a.x, b.x)) return new BigDecimal(0);
		return a.y.subtract(b.y).divide(a.x.subtract(b.x),100,BigDecimal.ROUND_HALF_EVEN);
	}
	static BigDecimal dist(NODE a,NODE b){
		return a.x.subtract(b.x).pow(2).add(a.y.subtract(b.y).pow(2));
	}
	static boolean eq(BigDecimal a,BigDecimal b){
		return a.subtract(b).abs().compareTo(eps)<0;
	}
	static boolean yes(){
		BigDecimal k1 = k(p[1], p[2]);
		BigDecimal k2 = k(p[1], p[3]);
		boolean f = !(eq(k1, k2));
//		System.out.println(k1 + " " + k2);
		if(eq(p[1].x, p[2].x) && eq(p[2].x, p[3].x)){
			f = false;
		}
		return f && eq(dist(p[1], p[2]),dist(p[2], p[3]));

	}
	static void work(){
		Scanner in = new Scanner(System.in);
		for(int i = 1;i<=3;i++){
			p[i] = new NODE(); 
			p[i].x = in.nextBigDecimal();
			p[i].y = in.nextBigDecimal();
			
		}
		if(yes()) System.out.println("YES");
		else System.out.println("NO");
	}
	public static void main(String[] args) {
//		BigDecimal a = new BigDecimal(4);
//		BigDecimal b = new BigDecimal(3);
//		test(a.divide(b,100,BigDecimal.ROUND_HALF_EVEN));
		work();
	}

}
