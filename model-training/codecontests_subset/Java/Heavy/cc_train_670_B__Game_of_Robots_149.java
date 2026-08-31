
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] in2 = br.readLine().split(" ");
		int n = Integer.parseInt(in2[0]);
		long k = Long.parseLong(in2[1]);
		String [] temp = br.readLine().split(" ");
		long [] in = new long [n];
		for (int i = 0; i < n; i++) {
			in[i] = Long.parseLong(temp[i]);
		}
		int j = 0;
		long res = -1;
		int i=1;
		while(j<k){
			if(j+i<k){
				j+=i;
				i++;
			}else{
				break;
			}
		}
		for (int l = 0; l <= i-1; l++) {
			j++;
			if(j==k){
				System.out.println(in[l]);
		return;
			}
		}
//		for (int i = 0; i < n; i++) {
//			for(int q =0; q<=i;q++){
//				j++;
//				if(j==k){
//					res = in[q];
//					System.out.println(res);
//					return;
//				}
//			}
//			
//		}
		
	}
}
