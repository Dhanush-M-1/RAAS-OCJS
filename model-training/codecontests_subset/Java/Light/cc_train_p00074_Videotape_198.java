import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.geom.*;
public class Main {
	private void doit(){
		Scanner sc = new Scanner(System.in);
		int max = 2 * 3600;
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a < 0 && b < 0 && c < 0) break;
			int time = a * 3600 + b * 60 + c;
			int rest = max - time;
			int ansc = rest % 60;
			int ansb = rest % 3600 / 60;
			int ansa = rest / 3600;
			System.out.printf("%02d:%02d:%02d\n", ansa, ansb,ansc);
			rest = rest * 3;
			ansc = rest % 60;
			ansb = rest % 3600 / 60;
			ansa = rest / 3600;
			System.out.printf("%02d:%02d:%02d\n", ansa, ansb,ansc);
		}
	}

	public static void main(String[] args) {
		Main obj = new Main();
		obj.doit();
	}
}