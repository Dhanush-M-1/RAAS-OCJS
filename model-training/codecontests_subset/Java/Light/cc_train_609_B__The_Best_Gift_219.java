import java.util.Scanner;

public class BestGift {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int possible =0;
		int bks[] = new int[m];
		for(int i =0;i<n;i++){
			bks[in.nextInt()-1]++;
		}
		for(int i =0;i<m;i++){
			for(int j =i+1;j<m;j++){
				possible+= bks[i] * bks[j];
			}
		}
		System.out.println(possible);
		in.close();
	}
}
