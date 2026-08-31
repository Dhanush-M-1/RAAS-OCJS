import java.util.*;

public class Problem710F {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int tt=0;tt<t;tt++) {
			int n=s.nextInt();
			int x[]=new int[n];
			int y[]=new int[n];
			for(int i=0;i<n;i++) {
				x[i]=s.nextInt();
			}
			for(int i=0;i<n;i++) {
				y[i]=s.nextInt();
			}
			ArrayList<point> arr=new ArrayList<>();
			arr.add(new point(1, 1));
			for(int i=0;i<n;i++) {
				arr.add(new point(x[i],y[i]));
			}
			Collections.sort(arr);
			
			int ret=0;
			for(int i=0;i<arr.size()-1;i++) {
				ret+=getCost(arr.get(i),arr.get(i+1));
				//System.out.println(ret);
			}
			System.out.println(ret);
		}

	}

	private static int getCost(point p1, point p2) {
		int right=p2.y-p1.y;
		int left=p2.x-p1.x-right;
		
		if(left==0) {
			if((p1.x+p1.y)%2==0) {
				return right;
			}else {
				return 0;
			}
			
		}else if((p1.x+p1.y)%2==0) {
			return left/2;
		}else {
			return (left+1)/2;
		}
		
		
	}

}
class point implements Comparable<point>{
	int x;
	int y;
	public point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(point p) {
		
		return x-p.x;
	}
}
