import java.util.*;
public class ProblemA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int[] arr = new int[a];
		for(int i =0;i<a;i++){
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int aye = 0;
		for(int i =a-1;i>=0;i--){
			if(b%arr[i] == 0){
				aye = arr[i];
				break;
			}
		}
		System.out.println(b/aye);
	}

}
