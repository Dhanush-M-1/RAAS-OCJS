import java.util.*;
public class Cf2 {
	public static class Point{
		int x;
		int y;
		int dis=0;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public boolean equals(Object o) {
			if(o!=null && o instanceof Point) {
				int xx=((Point)o).x;
				int yy=((Point)o).y;
				
				if(xx==this.x && yy==this.y ) {
					return true;
				}
				
			}
			return false;
		}
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x0=s.nextInt();
		int y0=s.nextInt();
		int x1=s.nextInt();
		int y1=s.nextInt();
		int n=s.nextInt();
		Set<Point>se=new HashSet<Point>();
		//boolean[][] vis=new boolean[100001][10];
		for(int i=0;i<n;i++) {
			int r=s.nextInt();
			int a=s.nextInt();
			int b=s.nextInt();
			for(int j=a;j<=b;j++)
				se.add(new Point(r,j));	
		}
		int[]xval= {1,-1,0,0,1,-1,1,-1};
		int[]yval= {0,0,1,-1,-1,-1,1,1};
		Point sp=new Point(x0,y0);
		Queue<Point>m=new LinkedList<Point>();
		Set<Point>vis=new HashSet<Point>();
		m.add(sp);
		vis.add(sp);
		while(!m.isEmpty()){
			Point tp=m.poll();
			if(tp.x==x1 && tp.y==y1) {
				System.out.println(tp.dis);
				return;
			}
			if(!se.contains(tp)) {
				continue;
			}
			for(int j=0;j<8;j++) {
				int xx=tp.x+xval[j];
				int yy=tp.y+yval[j];
				Point np=new Point(xx,yy);
				np.dis=tp.dis+1;
				if(!vis.contains(np)) {
					vis.add(np);
					m.add(np);
				}
			}
		}
		System.out.println(-1);
		return;
	}
}
