import java.util.*;
public class Main268A{
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int arr[][] = new int[n][2];

		for(int i=0;i<n;i++){
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}

		int matches = 0;

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[j][0]==arr[i][1]){
					matches++;
				}
			}
		}

		System.out.println(matches);

	}
}