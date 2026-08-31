import java.util.Scanner;


public class Levko {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean possible = true;
		long[] atMost = new long[n];
		for(int i = 0; i < n; i++){
			atMost[i] = 1000000000;
		}
		long[][] input = new long[m][4];
		long[] addedValue = new long[n];
		for(int i = 0; i < m; i++){
			int t = sc.nextInt();
			int ii = sc.nextInt()-1;
			int jj = sc.nextInt()-1;
			long dOrMax = sc.nextLong();
			input[i][0] = t;
			input[i][1] = ii;
			input[i][2] = jj;
			input[i][3] = dOrMax;
			if(t == 1){
				while(ii <= jj){
					addedValue[ii] += dOrMax;
					ii++;
				}
			}
			else{
				boolean ok = false;
				while(ii <= jj){
					if(atMost[ii] + addedValue[ii] >= dOrMax){
						atMost[ii] = dOrMax - addedValue[ii];
						ok = true;
					}
					ii++;
				}
				if(!ok){
					possible = false;
				}
			}
		}
		long[] addedValue2 = new long[n];
		for(int i = 0; i < m; i++){
			if(input[i][0] == 2){
				boolean ok2 = false;
				int k = (int) input[i][1];
				while(k <= input[i][2]){
					if(addedValue2[k] + atMost[k] == input[i][3]){
						ok2 = true;
					}
					if(atMost[k] < -1000000000){
						possible = false;
					}
					k++;
				}
				if(!ok2){
					possible = false;
				}
			}
			else{
				int k = (int) input[i][1];
				while(k <= input[i][2]){
					addedValue2[k] += input[i][3];
					k++;
				}

			}
		}
		if(possible){
			System.out.println("YES");
			for(int i = 0; i < n; i++){
				if(i != 0){
					System.out.print(" ");
				}
				System.out.print(atMost[i]);
			}

		}
		else{
			System.out.println("NO");
		}
	}
}
