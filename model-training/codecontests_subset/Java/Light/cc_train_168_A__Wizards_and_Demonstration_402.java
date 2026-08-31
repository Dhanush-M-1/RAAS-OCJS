import java.util.*;

// Div2 Round114 3/27 2012
public class Main {
	
	void A(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = (int)Math.ceil((double)n*y/100);
		if((x-a)*-1 > 0){
			System.out.println((x-a)*-1);
		}else{
			System.out.println(0);
		}
	}
	
	public static void main(String[] args) {
		new Main().A();
	}
}
