import java.util.Scanner;

public class TheBestGift {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		int[] genres = new int[m];
		
		for (int i=0;i<m;i++){
			genres[i] = 0;
		}
		
		for (int i=0;i<n;i++){
			genres[s.nextInt()-1]++;
		}
		
		int result = 0;
		
		for (int i=0;i<m-1;i++){
			for (int j=i+1;j<m;j++){
				result += genres[i] * genres[j];
			}
		}
		
		System.out.println(result);
		
		s.close();
	}

}