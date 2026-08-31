import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}

	void solve() {
		Scanner sc = new Scanner(System.in);
		String p=sc.next();
		char[]pass=p.toCharArray();
		int n=sc.nextInt();
		String[]s=new String[n];
		boolean check1=false;
		boolean check2=false;
		for(int i=0;i<n;i++) {
			s[i]=sc.next();
			if(s[i].charAt(0)==pass[1]) {
				check1=true;
			}
			if(s[i].charAt(1)==pass[0]) {
				check2=true;
			}
			if(s[i].equals(p)) {
				check1=true;
				check2=true;
			}
		}
		if(check1 && check2) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}
}
