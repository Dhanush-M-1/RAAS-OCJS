import java.util.*;

class Main {
	Scanner sc = new Scanner(System.in);

	public String parse(int t){
		return String.format("%02d:%02d:%02d",t/3600,(t%3600)/60,t%60);
	}

	public void run() {
		while(true){
			int h=sc.nextInt(),m=sc.nextInt(),s=sc.nextInt();
			if(h==-1 && m==-1 && s==-1)break;
			int rest=7200-h*3600-m*60-s;
			ln(parse(rest));
			ln(parse(3*rest));
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