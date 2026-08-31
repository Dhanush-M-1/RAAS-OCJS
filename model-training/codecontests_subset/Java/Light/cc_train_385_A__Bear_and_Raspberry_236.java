import java.util.Scanner;


public class raspbery {

	public static void main(String[] args) {
		int n, c;
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		c = input.nextInt();
		int arr[] = new int [n];
		for(int i = 0; i < arr.length; i ++){
			arr[i] = input.nextInt();
		}
		int res = arr[0] - arr[1];
		for(int i = 1; i < arr.length - 1; i ++){
			if(arr[i] - arr[i + 1] > res){
				res = arr[i] - arr[i + 1];
			}
		}
		if(res - c < 0){
			System.out.println(0);
		}
		else{
			System.out.println(res - c);
		}

	}

}
