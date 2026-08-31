import java.util.*;
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n , k;
		n = sc.nextInt();
		k = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int temp = 0, temp2 = 0;
		
		while(temp < k) {
			temp += ++temp2;		
			}
		temp = temp - (temp2 - 1);
		System.out.println(arr[k-temp]);
	}
}
