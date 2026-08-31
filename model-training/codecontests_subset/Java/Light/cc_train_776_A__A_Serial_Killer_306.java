import java.util.*;
public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> a = new ArrayList<String>();
		a.add(in.next());
		a.add(in.next());
		System.out.println(a.get(0)+" "+a.get(1));
		int n = in.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<2;j++) {
				String x = in.next();
				if(a.contains(x)) {
					a.remove(x);
				}else {
					a.add(x);
				}
			}
			System.out.println(a.get(0)+" "+a.get(1));
		}
	}
}
