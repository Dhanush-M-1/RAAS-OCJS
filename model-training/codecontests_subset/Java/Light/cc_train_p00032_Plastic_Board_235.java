import java.util.*;
public class Main {
	Scanner sc;
	
	boolean judge(int[] x) {
		if (x[0]*x[0]+x[1]*x[1]==x[2]*x[2]) return true;
		else return false;
	}
	
	void run () {
		sc = new Scanner(System.in);
		int rec = 0,loz = 0;
		while (sc.hasNext()) {
			String[] s = sc.next().split(",");
			int[] x = new int[3];
			for (int i=0;i<3;i++) x[i] = Integer.parseInt(s[i]);
			if (x[0] == x[1] ) loz++;
			if (judge(x)) rec++;
		}
		System.out.println(rec);
		System.out.println(loz);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}
}