
import java.util.Scanner;

public class Main {
	private static Scanner input;

	public static void main(String args[]){
		input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		boolean flag = true;
		long[] aux = new long[n];
		for(int i = 0; i < n; i++){
			aux[i] = 1000000000;
		}
		long[][] values = new long[m][4];
		long[] addValues = new long[n];
		for(int i = 0; i < m; i++){
			int t = input.nextInt();
			int ii = input.nextInt()-1;
			int jj = input.nextInt()-1;
			long dOrMax = input.nextLong();
			values[i][0] = t;
			values[i][1] = ii;
			values[i][2] = jj;
			values[i][3] = dOrMax;
			if(t == 1){
				while(ii <= jj){
					addValues[ii] += dOrMax;
					ii++;
				}
			}
			else{
				boolean ok = false;
				while(ii <= jj){
					if(aux[ii] + addValues[ii] >= dOrMax){
						aux[ii] = dOrMax - addValues[ii];
						ok = true;
					}
					ii++;
				}
				if(!ok){
					flag = false;
				}
			}
		}
		long[] addedValue2 = new long[n];
		for(int i = 0; i < m; i++){
			if(values[i][0] == 2){
				boolean ok2 = false;
				int k = (int) values[i][1];
				while(k <= values[i][2]){
					if(addedValue2[k] + aux[k] == values[i][3]){
						ok2 = true;
					}
					if(aux[k] < -1000000000){
						flag = false;
					}
					k++;
				}
				if(!ok2){
					flag = false;
				}
			}
			else{
				int k = (int) values[i][1];
				while(k <= values[i][2]){
					addedValue2[k] += values[i][3];
					k++;
				}

			}
		}
		if(flag){
			System.out.println("YES");
			for(int i = 0; i < n; i++){
				if(i != 0){
					System.out.print(" ");
				}
				System.out.print(aux[i]);
			}

		}
		else{
			System.out.println("NO");
		}
	}
}
