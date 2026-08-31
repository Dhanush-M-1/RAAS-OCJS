import java.util.*;
public class candles {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int b = sc.nextInt();
	int ans =  a;
	int velas =  a;
	
		while(velas>=b){
		ans= ans + velas/b;
		velas= velas/b + velas%b;
	
		}
		System.out.println(ans);

	}
}
