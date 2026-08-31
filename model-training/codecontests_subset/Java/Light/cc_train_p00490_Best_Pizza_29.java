import java.util.*;

public class Main {
	Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		new Main();
	}
	public Main() {
		new AOJ0567().doIt();
	}
	
	class AOJ0567{
		void doIt(){
			int n = in.nextInt();
			int a = in.nextInt(),b = in.nextInt();
			int kin = a,kizi_cal = in.nextInt();
			int[] topping = new int[n];
			for(int i=0;i<n;i++)topping[i] = in.nextInt();
			Arrays.sort(topping);
			double before = 0,col = kizi_cal;
			for(int i=n-1;i>=0;i--){
				col+=topping[i];
				kin+=b;
				double now = (double)col/kin;
//				System.out.println(col+" "+kin);
//				System.out.println(now+" "+before);
				if(now<before){
					kin-=b;
					col-=topping[i];
					break;
				}
				before = now;
			}
			System.out.println((int)(col/kin));
		}
	}
}