import java.util.*;

public class Main{
	Scanner sc = new Scanner(System.in);
	
	private void doit(){
		while(true){
			int n = sc.nextInt();
			if(n == 0) break;
			int [] data = new int[n];
			for(int i = 0; i  <n; i++){
				data[i] = sc.nextInt();
			}
			int count = 0;
			for(;;){
				boolean flg = false;
				for(int j = 0; j < n-1; j++){
					if(data[j] > data[j + 1]){
						int temp = data[j];
						data[j] = data[j+1];
						data[j+1] = temp;
						count++;
						flg = true;
					}
				}
				if(! flg){
					break;
				}
			}
			System.out.println(count);
		}
	}

	private void debug(Object... o) { System.out.println("debug = " + Arrays.deepToString(o)); }

	public static void main(String[] args) {
		new Main().doit();
	}
}