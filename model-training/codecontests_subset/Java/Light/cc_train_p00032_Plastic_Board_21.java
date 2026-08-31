import java.util.*;

class Main {
	Scanner sc = new Scanner(System.in);
	
	int n;
	public void run() {
		int rect=0,lozenge=0;
		while(sc.hasNext()){
			String str=sc.next();
			String[] sa=str.split(",");
			int[] edge=new int[]{
					Integer.parseInt(sa[0]),
					Integer.parseInt(sa[1]),
					Integer.parseInt(sa[2]),
				};
			
			if(edge[0]+edge[1]>edge[2]){
				if(edge[0]==edge[1] )lozenge++;
				if(edge[0]*edge[0]+edge[1]*edge[1]
						==edge[2]*edge[2])rect++;
			}
		}
		ln(rect);
		ln(lozenge);
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