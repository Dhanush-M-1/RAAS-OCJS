import java.util.*;



class Main {
	Scanner sc = new Scanner(System.in);

	int n;
	public void run() {
		while(sc.hasNext()){
			String str=sc.next();
			String[] strs=str.split(",");
			P[] pos=new P[4];
			for(int i=0;i<4;i++){
				double x=Double.parseDouble(strs[2*i]);
				double y=Double.parseDouble(strs[2*i+1]);
				pos[i]=new P(x,y);
			}
			boolean ok=true;

			int ccw0=P.ccw(pos[0],pos[1],pos[2]);

			for(int i=1;i<4;i++){
				int ccw=P.ccw(pos[i],pos[(i+1)%4],pos[(i+2)%4]);
				if(ccw0*ccw<0){
					ok=false;break;
				}
			}
			ln(ok?"YES":"NO");
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}

	public static void pr(Object o) {
		System.out.print(o);
	}

	public static void ln(Object o) {
		System.out.println(o);
	}

	public static void ln() {
		System.out.println();
	}
}

class P{
	double x;
	double y;
	P(double _x,double _y){
		x=_x;
		y=_y;
	}

	public static double dot(P a,P b){
			return a.x*b.x+a.y*b.y;
	}
	public static  double cross(P a,P b){
		return a.x*b.y-a.y*b.x;
	}
	public P a(P a){
		return new P(x+a.x,y+a.y);
	}
	public P s(P a){
		return new P(x-a.x,y-a.y);
	}

	public double norm(){
		return Math.sqrt(x*x+y*y);
	}

	public static int ccw(P a,P b,P c){
		if(P.cross(b.s(a),c.s(a))>Double.MIN_NORMAL){
			return 1;
		}
		if(P.cross(b.s(a),c.s(a))<-Double.MIN_NORMAL){
			return -1;
		}
		if(P.dot(b,c)<-Double.MIN_NORMAL)return 2;
		if(b.norm()<c.norm()-Double.MIN_NORMAL)return -2;
		return 0;
	}
}