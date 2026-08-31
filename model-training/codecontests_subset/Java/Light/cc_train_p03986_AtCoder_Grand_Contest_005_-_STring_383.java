import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		sc.close();
		int len = x.length();
		int nt = 0;
		int ns = 0;
		for(int i = 0; i<len; i++){
			if(x.charAt(i) == 'S'){
				ns++;
			}else{
				if(ns == 0){
					nt++;
				}else{
					ns--;
				}
			}
		}
		int ans = nt*2;
		System.out.println(ans);
	}

}