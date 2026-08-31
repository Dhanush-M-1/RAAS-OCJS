
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		label:while(cin.hasNext()){
			String[] s=cin.next().split(",");
			P[] p=new P[4];
			for(int i=0;i<8;i=i+2){
				double a = Double.parseDouble(s[i]);
				double b = Double.parseDouble(s[i+1]);
				p[i/2]=new P(a,b);
			}
			P[] con=Main.convexHull(p);
			if(con.length<4){
				System.out.println("NO");
				continue;
			}
			else{
				System.out.println("YES");
			}
		}

	}
	public static final double EPS = 1e-8;

	static class P implements Comparable<P>{
		public double x;
		public double y;
		public P(double x, double y) {
			this.x = x;
			this.y = y;
		}
		//座標が左下にあるほどソート列において前に来る
		public int compareTo(P o) {
			if(equals(o))return 0;
			if(Math.abs(x-o.x)<EPS){
				return y-o.y<0?-1:y-o.y>0?1:0;
			}
			return x-o.x<0?-1:x-o.x>0?1:0;
		}
		public boolean equals(P o){
			return Math.abs(x-o.x)<EPS && Math.abs(y-o.y)<EPS;
		}
		@Override
		public String toString() {
			return "("+x+","+y+")";
		}
	}

	/**
	 * s->tベクトル
	 */
	static class Vec{
		public P s;
		public P t;
		public double dx;
		public double dy;
		public Vec(P t){
			this.s = new P(0, 0);
			this.t = t;
			dx = t.x-s.x;
			dy = t.y-s.y;
		}
		public Vec(P s, P t) {
			this.s = s;
			this.t = t;
			dx = t.x-s.x;
			dy = t.y-s.y;
		}
		public Vec reverse(){
			return new Vec(t, s);
		}
		/**
		 * ベクトルの大きさ
		 */
		public double norm(){
			return Math.sqrt(dx*dx+dy*dy);
		}
		/**
		 * 内積
		 */
		public double dotProduct(Vec o){
			return dx*o.dx + dy*o.dy;
		}
		/**
		 * 外積
		 */
		public double crossProduct(Vec o){
			return dx*o.dy - dy*o.dx;
		}
		/**
		 * ベクトル o と直交しているか
		 * 交点を持っている必要はない
		 * Verify: AOJ0058
		 */
		public boolean isOrthogonal(Vec o){
			return dotProduct(o)==0;
		}
		/**
		 * ベクトル o と平行か
		 */
		public boolean isParallel(Vec o){
			return crossProduct(o)==0;
		}
		/**
		 * CCW
		 */
		public int ccw_(P p){
			return ccw(s, t, p);
		}
		/**
		 * ベクトル o と交わるか
		 */
		public boolean isCross(Vec o){
			return ccw_(o.s)*ccw_(o.t) < EPS && o.ccw_(s)*o.ccw_(t) < EPS ||
					ccw_(o.s)*ccw_(o.t) < EPS && o.ccw_(s)*o.ccw_(t) < EPS;
		}
		/**
		 * 点p からベクトル延長線上へ垂線を引いたときの長さ
		 */
		public double distanceFromPoint(P p){
			Vec o = new Vec(s, p);
			return Math.abs(crossProduct(o))/norm();
		}
		/**
		 * 点pをこのベクトルに対して線対象の位置に移す
		 * 方程式ガン解きだが、誤差は少ないらしい
		 * Verify: AOJ0081
		 */
		public P symmetricPoint(P p){
			if(s.x==t.x){
				return new P(p.x+(s.x-p.x)*2, p.y);
			}
			else if(s.y==t.y){
				return new P(p.x, p.y+(s.y-p.y)*2);
			}
			else{
				double alpha = (s.y-t.y)/(s.x-t.x);
				double beta = s.y-s.x*alpha;
				double x = (2*p.y*alpha-2*alpha*beta+p.x-alpha*alpha*p.x)/(alpha*alpha+1);
				double y = (p.x-x)/alpha+p.y;
				return new P(x, y);
			}
		}
		@Override
		public String toString() {
			return s+"->"+t;
		}
	}

	/**
	 * CCW: counter clock wise
	 * 1 : clock wise
	 * -1: counter clock wise
	 * 2 : c--a--b on line
	 * -2: a--b--c on line
	 * 0 : a--c--b or a--c=b on line
	 */
	public static int ccw(P p1, P p2, P p3){
		Vec a = new Vec(p1, p2);
		Vec b = new Vec(p1, p3);
		if(a.crossProduct(b)<EPS)return 1;
		if(a.crossProduct(b)>EPS)return -1;
		//if program run here, three points on line because AxB = 0 shows parallel
		if(a.dotProduct(b)<EPS)return 2;
		if(a.norm() < b.norm())return -2;
		return 0;
	}

	/**
	 * 頂点列を与えてその多角形の面積を求める
	 * 頂点列はどっちまわりでもいい
	 * Vecの外積を使うとうまくいかないので別途外積を書き下している
	 * 誤差が気になるなら2で割らないといいっぽいよ
	 */
	public static double area(P[] p){
		int n = p.length;
		if(n<3)return 0;
		double a = 0;
		for(int i=0;i<n;i++){
			a += p[i].x*p[(i+1)%n].y-p[i].y*p[(i+1)%n].x;
		}
		return Math.abs(a/2);
	}

	/**
	 * 反時計回りに凸包を求める O(n log n)
	 * Graham's scan algorithm
	 * Verify: UVa109
	 */
	public static P[] convexHull(P[] p){
		int n = p.length;
		if(n<3)return p;
		Arrays.sort(p);
		LinkedList<P> lower = new LinkedList<P>();
		lower.add(p[0]);
		lower.add(p[1]);
		for(int i=2;i<n;i++){
			lower.add(p[i]);
			while(lower.size()>=3){
				int k = lower.size()-1;
				if(ccw(lower.get(k-2), lower.get(k-1), lower.get(k))==-1 && ccw(lower.get(k-1), lower.get(k), lower.get(k-2))==-1)break;
				lower.remove(k-1);
			}
		}
		LinkedList<P> upper = new LinkedList<P>();
		upper.add(p[n-1]);
		upper.add(p[n-2]);
		for(int i=n-3;i>=0;i--){
			upper.add(p[i]);
			while(upper.size()>=3){
				int k = upper.size()-1;
				if(ccw(upper.get(k-2), upper.get(k-1), upper.get(k))==-1 && ccw(upper.get(k-1), upper.get(k), upper.get(k-2))==-1)break;
				upper.remove(k-1);
			}
		}
		upper.remove(0);
		upper.remove(upper.size()-1);
		int N = lower.size()+upper.size();
		P[] res = new P[N];
		int x = 0;
		for(P q:upper)res[x++] = q;
		for(P q:lower)res[x++] = q;
		//			if(area(res)<=EPS)return p;
		return res;
	}
}