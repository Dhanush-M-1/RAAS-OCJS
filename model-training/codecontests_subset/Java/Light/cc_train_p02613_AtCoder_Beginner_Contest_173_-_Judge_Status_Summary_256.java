import java.util.Scanner;
public class Main {
	int as,kl,o,n,m,hun,p;
	String op;
	Scanner sc = new Scanner(System.in);
	public void solve() {	
n=sc.nextInt();

for(o=0;o<n;o++) {
	op=sc.next();
	if(op.equals("AC")) {
		as=as+1;
	}else if(op.equals("WA")) {
		kl=kl+1;
	}else if(op.equals("TLE")) {
		hun=hun+1;
	}else if(op.equals("RE")) {
		m=m+1;
	}
	
}
System.out.println("AC x "+as);
System.out.println("WA x "+kl);
System.out.println("TLE x "+hun);
System.out.println("RE x "+m);

	}
	public static void main(String[] args) {
		new Main().solve();
	
	}
}