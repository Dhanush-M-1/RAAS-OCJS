import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner sc;
	
	public void run(){
		sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0) break;
			calc(n);
		}
	}
	public void calc(int n){
		int count = 0;
		String b = null;
		String a = null;
		for(int i = 0; i < n ; i++){
			if(i % 2 == 0){
				b = sc.next();
			}
			else {
				a = sc.next();
				if(b.equals("lu") && a.equals("ru")) count++;
				else if(b.equals("ru") && a.equals("lu")) count++;
				else if(b.equals("ld") && a.equals("rd")) count++;
				else if(b.equals("rd") && a.equals("ld")) count++;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args){
		new Main().run();
	}
	
}