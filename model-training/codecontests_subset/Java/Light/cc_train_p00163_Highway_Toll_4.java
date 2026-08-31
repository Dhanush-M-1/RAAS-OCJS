import java.util.*;

public class Main{
	Scanner sc = new Scanner(System.in);
	int [][] data = {
			{0,300,500,600, 700, 1350, 1650},
			{6,0,350,450,600,1150,1500},
			{13,7,0,250,400,1000,1350},
			{18,12,5,0,250,850,1300},
			{23,17,10,5,0,600,1150},
			{43,37,30,25,20,0,500},
			{58,52,45,40,35,15,0},
	};
	
	private void doit(){
		while(true){
			int a = sc.nextInt() - 1;
			if(a == -1) break;
			int timeA = sc.nextInt() * 100 + sc.nextInt();
			int b = sc.nextInt() - 1;
			int timeB = sc.nextInt() * 100 + sc.nextInt();
			boolean ishalf = isOK(timeA) || isOK(timeB);
			int min = Math.min(a, b);
			int max = Math.max(a, b);
			if(data[max][min] > 40 ){
				ishalf = false;
			}
			if(ishalf){
				int res = data[min][max];
				if(data[min][max] % 100 != 0){
					res += 50;
				}
				System.out.println(res / 2);
			}
			else{
				System.out.println(data[min][max]);
			}
		}
	}
	
	private boolean isOK(int timeA) {
		if(1730 <= timeA && timeA <= 1930){
			return true;
		}
		return false;
	}

	private void debug(Object... o) { System.out.println("debug = " + Arrays.deepToString(o)); }

	public static void main(String[] args) {
		new Main().doit();
	}
}