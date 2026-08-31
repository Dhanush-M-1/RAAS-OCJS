import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;

public class Main{
	Scanner sc = new Scanner(System.in);

	private void doit(){
		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			int [] data = new int[12];
			for(int i = 0 ; i < 12; i++){
				data[i] = sc.nextInt() - sc.nextInt();
			}
			int sum = 0;
			boolean flg= false;
			int ans = -1;
			for(int i = 0 ; i < 12; i++){
				sum += data[i];
				if(sum >= n){
					ans = i + 1;
					flg = true;
					break;
				}
			}
			if(flg){
				System.out.println(ans);
			}
			else{
				System.out.println("NA");
			}
		}
	}

	private void debug(Object... o) { System.out.println("debug = " + Arrays.deepToString(o)); }

	public static void main(String[] args) {
		new Main().doit();
	}
	
	
}//end file