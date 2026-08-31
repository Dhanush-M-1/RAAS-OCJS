
import java.util.*;
import static java.lang.System.*;

class Main {
	public static Scanner sc = new Scanner(in);
	public static Random rand=new Random();

	public void run() {
		int q=sc.nextInt();
		while(q--!=0){
			String n=sc.next();

			int t=0;
			while(n.length()>1){
				int max=0;
				for(int i=1;i<n.length();i++){
					String a=n.substring(0,i);
					String b=n.substring(i);
					max=Math.max(Integer.parseInt(a)*Integer.parseInt(b),max);
				}
				n=max+"";
				t++;
			}
			ln(t);
		}

	}
	public static void main(String[] args) {
		new Main().run();
	}

	public int[] nextIntArray(int n){
		int[] res=new int[n];
		for(int i=0;i<n;i++){
			res[i]=sc.nextInt();
		}
		return res;
	}
	public static void pr(Object o) {
		out.print(o);
	}
	public static void ln(Object o) {
		out.println(o);
	}
	public static void ln() {
		out.println();
	}
}