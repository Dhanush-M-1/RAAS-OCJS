import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int [] arr= new int[n];
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            int num = scanner.nextInt();
           arr[num-1] ++;
        }
        for (int i = 0; i < k; i++) {
            for (int j = i+1; j <k ; j++) {
                sum += arr[i]*arr[j];
            }
        }
        System.out.print(sum);
    }
}