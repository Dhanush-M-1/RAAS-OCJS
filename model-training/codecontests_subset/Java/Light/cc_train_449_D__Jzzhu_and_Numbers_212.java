import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p0449D {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		
		line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		
		line = br.readLine().split(" ");
		int[][] fSub = new int[21][1<<20];
		for(int n=0;n<N;n++){
			fSub[0][Integer.parseInt(line[n])]++;
		}
		
		for(int k = 1; k <= 20; k++){
			for(int x = 0; x < (1<<20); x++){
				fSub[k][x] = fSub[k-1][x];
				if(((x >> (k-1)) & 1) == 0){
					fSub[k][x] += fSub[k-1][x+(1<<(k-1))];
				}
			}
		}
		
		int evenAns = 0;
		int oddAns = 0;
		for(int x = 0; x < (1<<20); x++){
			if((Integer.bitCount(x) & 1) == 0){
				evenAns = (evenAns + (int)pow(2, fSub[20][x])) % 1_000_000_007;
			}
			else{
				oddAns = (oddAns + (int)pow(2, fSub[20][x])) % 1_000_000_007;
			}
		}
		
		System.out.println((evenAns + 1_000_000_007 - oddAns) % 1_000_000_007);
	}
	static long pow(int base, int exp){
		if(exp == 0){
			return 1L;
		}
		long ret = pow(base, exp/2);
		ret = ret * ret % 1_000_000_007;
		if(((exp >> 1) << 1) != exp){
			ret = ret * base % 1_000_000_007;
		}
		return ret;
	}
}
