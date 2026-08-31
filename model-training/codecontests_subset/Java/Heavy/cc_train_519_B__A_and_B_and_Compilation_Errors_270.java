import java.util.*;
public class AAndBCompilationError {
	static Scanner sc = new Scanner(System.in);
	public static void main(String arg[]) {
		solve();
	}
	static void solve() {
		int n = sc.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		List<Integer> c = new ArrayList<Integer>();
		for(int i=0; i<n;i++) {
			a.add(sc.nextInt());
		}
		for(int i=0; i<n-1;i++) {
			b.add(sc.nextInt());
		}
		for(int i=0; i<n-2;i++) {
			c.add(sc.nextInt());
		}
		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(c);
		int y=0,z=0;
		boolean flg = true;
		for(int i=0; i<n-1; i++) {
			if(a.get(i) != (int)b.get(i)) {
				y=a.get(i);
				flg=false;
				//System.out.println(a.get(i)+" "+b.get(i));
				break;
			}
		}
		if(flg) {
			y=a.get(a.size()-1);
		}else {
			flg=true;
		}
		for(int i=0; i<n-2; i++) {
			if(b.get(i) != (int)c.get(i)) {
				z=b.get(i);
				flg=false;
				break;
			}
		}
		if(flg) {
			z=b.get(b.size()-1);
		}
		System.out.println(y);
		System.out.println(z);
	}
}