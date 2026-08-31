import java.util.*;

public class WoodCutter {
	final static long MIN = -1000000000000000l;
	final static long MAX = 10000000000000000l;
	public static void main(String[] args) {
		new WoodCutter().go();
	}
	
	public void go() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		ArrayList<Tree> a = new ArrayList<Tree>();
		a.add(new Tree(MIN,0l));
		for(int i=1;i<=n;i++) {
			a.add(new Tree(scan.nextLong(),scan.nextLong()));
		}
		a.add(new Tree(MAX,0l));
		
		long strX = MIN;
		long strC = 0;
		long rightX = MIN;
		long rightC = 0;
		long ans = 1;
		for(int i=1;i<=n;i++) {
			long x = a.get(i).x;
			long h = a.get(i).h;
			long xNext = a.get(i+1).x;
			long hNext = a.get(i+1).h;
			
			long strCT = strC;
			if(x-h > strX) {
				strCT++;
			}
			if(x>rightX) {
				strCT = Math.max(strCT, rightC);
			}
			if(x-h>rightX) {
				strCT = Math.max(strCT, rightC+1);
			}
			
			long rightXT = x;
			long rightCT = Math.max(strC, rightC);
			if(x+h < xNext) {
				rightCT++;
				rightXT = x+h;
			}
			
			strC = strCT;
			strX = x;
			rightX = rightXT;
			rightC = rightCT;
			ans = Math.max(ans, Math.max(strC, rightC));
			//System.out.println(strX + " " + strC + " -- " + rightX + " " + rightC);
			
		}
		
		System.out.println(ans);
		
	}
	
	class Tree{
		long x;
		long h;
		public Tree(long x, long h) {
			this.x = x;
			this.h = h;
		}
	}
}
