import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.math.BigInteger;
 
public class Main implements Runnable {
	
	static int mod = 1000000007;
	
    public static void main(String[] args) {
    	new Thread(null, new Main(), "", 1024 * 1024 * 1024).start();
    }
    
    public void run() {
       	PrintWriter out = new PrintWriter(System.out);
        FastScanner sc = new FastScanner();

        int n = sc.nextInt();
        ArrayList<Point> pol = new ArrayList<>();
         
        for(int i=0;i<n;i++){
            pol.add(new Point(sc.nextDouble(),sc.nextDouble()));
        }
         
        Polygon polygon = new Polygon(pol);
 
        if(polygon.isConvex()){
            out.println(1);
        }
        else{
            out.println(0);
        }
        
        out.flush();
    }

    
}

class Point implements Comparable<Point>{
	double x,y;
	static final double eps = 0.00000001;
	
	public Point(double a, double b){
		this.x = a;
		this.y = b;
	}
	
	//距離の2乗
	public double d2(Point b){
		return (x-b.x)*(x-b.x) + (y-b.y)*(y-b.y);
	}
	
	//通常のユークリッド距離
	public double dist(Point b){
		return Math.sqrt((x-b.x)*(x-b.x) + (y-b.y)*(y-b.y));
	}
	
	//p1へのベクトルからみてp2へのベクトルが反時計回りなら1、時計回りなら2
	//↑が同一直線状にあるとき、→p2が→p1と反対側なら3、→p2が→p1の延長線上なら4、→p2が→p1上にあれば5を返す
	int direction(Point p1, Point p2){
		
		if(p2.x == x && p2.y == y){
			return 5;
		}
		
		//外積の第三成分 = |→p1||→p2|sinθ
		double det = (p1.x -x)*(p2.y-y) - (p2.x -x)*(p1.y - y);
		
		if(det>eps){
			return 1;
		}
		else if(det<-eps){
			return 2;
		}
		else{	//同一直線状
			if((p1.x-x >0 == p2.x-x <0) && p1.x-x != 0){	//反対側
				return 3;
			}
			else if((p1.y-y >0 == p2.y-y <0) && p1.y-y != 0){	//反対側
				return 3;
			}
			else{
				double d10 = d2(p1);	//p1とp0の距離^2
				double d20 = d2(p2);	//p2とp0の距離^2
				if(d10 < d20){	//p2のほうが遠い
					return 4;
				}
				else{
					return 5;
				}
			}
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Point o){
		if(x!=o.x){
			return Double.compare(x,o.x);
		}
		return Double.compare(y, o.y);
	}
		
}

class Polygon {
	static final double eps = 0.00000001;
	ArrayList<Point> pl; //反時計周り
	
	public Polygon(ArrayList<Point> pol){
		this.pl = pol;
	}
	
	//面積を導出
	double area(){
		//|det|/2は作る三角形の面積に一致
		double ans = 0;
		
		for(int i=0;i<pl.size();i++){
			ans += det(pl.get(i), pl.get(next(i)));
		}
		
		return ans/2;
	}
	
	//pが多角形に含まれるなら2、pが辺上にあるなら1、pが外側にあるなら0を返す
	int contain(Point p){
		//pからx軸と平行・正方向の半直線を引き、奇数回交差すれば内部にある
		boolean isIn = false;
		for(int i=0;i<pl.size();i++){
			int upid = i;
			int downid = next(i);
			if(pl.get(i).y < pl.get(next(i)).y){
				upid = next(i);
				downid = i;
			}
			
			//ベクトルを便宜的に
			Point pup = new Point(pl.get(upid).x - p.x, pl.get(upid).y - p.y);	//p→p_i
			Point pdown = new Point(pl.get(downid).x - p.x, pl.get(downid).y - p.y); //p→p_next(i)
			
			double det = det(pup, pdown);
			if(pup.y > 0 && 0 >= pdown.y){	//2重カウントしないために不等号を>と>=にする
				if(det < 0){
					isIn = !isIn;
				}
			}
			
			//辺上判定
			if(Math.abs(det) < eps){	//p→p_iとp→p_next(i)が一直線上
				if(pup.x * pdown.x + pup.y * pdown.y <= 0){	//pからみて同方向でない
					return 1;
				}
			}
		}
		
		if(isIn){
			return 2;
		}
		else{
			return 0;
		}
	}
	
	//凸多角形か判定
	boolean isConvex(){
		//反時計回りに回り続けるなら凸
		for(int i=0;i<pl.size();i++){
			if(pl.get(next(i)).direction(pl.get(i),pl.get(next(next(i)))) == 1){
				return false;
			}
		}
		return true;
	}
	
	//反時計回りに1つ進んだ頂点のindex
	int next(int id){
		int size = pl.size();
		if(id<=size-2){
			return id+1;
		}
		else{
			return 0;
		}
	}
	//ベクトルのdet
	static double det(double x1, double y1, double x2, double y2){
		return x1*y2 - x2*y1;
	}
	static double det(Point p, Point q){
		return p.x*q.y - p.y*q.x;
	}
	
}

class FastScanner {
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;
	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		} else {
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}
	private int readByte() {
		if (hasNextByte())
			return buffer[ptr++];
		else
			return -1;
	}
	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}
	public boolean hasNext() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr]))
			ptr++;
		return hasNextByte();
	}
	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	public long nextLong() {
		if (!hasNext())
			throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while (true) {
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			} else if (b == -1 || !isPrintableChar(b)) {
				return minus ? -n : n;
			} else {
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}
	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
			throw new NumberFormatException();
		return (int) nl;
	}
	public int[] nextintArray(int n){
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = nextInt();
		}
		return a;
	}
	public long[] nextlongArray(int n){
		long[] a = new long[n];
		for(int i=0;i<n;i++){
			a[i] = nextLong();
		}
		return a;
	}
	public Integer[] nextIntegerArray(int n){
		Integer[] a = new Integer[n];
		for(int i=0;i<n;i++){
			a[i] = nextInt();
		}
		return a;
	}
	public int[][] nextintMatrix(int h, int w){
		int[][] mat = new int[h][w];
		for(int i=0;i<h;i++){
			for(int j=0;j<w;j++){
				mat[i][j] = nextInt();
			}
		}
		return mat;
	}
	public double nextDouble() {
		return Double.parseDouble(next());
	}
}
