import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _0962MathProblem {
	int left;
	int right;
	
	public _0962MathProblem(int l,int r) {
		this.left=l;
		this.right=r;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0) {
			int n=sc.nextInt();
			int rmin=Integer.MAX_VALUE;
			int lmax=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				int l=sc.nextInt();
				int r=sc.nextInt();
				rmin=Math.min(rmin, r);
				lmax=Math.max(lmax, l);
			}
	
			System.out.println(Math.max(0,lmax-rmin));
			t--;
			}
			
		}
	}
class sort implements Comparator<_0962MathProblem>{

	@Override
	public int compare(_0962MathProblem a, _0962MathProblem b) {
		if(a.left==b.right) {
			return a.right-b.right;
		}
		else {
			return a.left-b.left;
		}
	}
	

}
