import java.util.*;

public class A_and_B_and_Compilation_Error_519B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int arr1[] = new int[n-1];
		for(int i = 0; i<n-1; i++) {
			arr1[i] = sc.nextInt();
		}
		int arr2[] = new int[n-2];
		for(int i = 0; i<n-2; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int a = arr[n-1];
		int b = arr1[n-2];
		loop1:for(int i = 0; i<n-1; i++) {
			if(arr[i]==arr1[i]) {
				continue;
			}
			else {
				a = arr[i];
				break loop1;
			}
		}
		loop2:for(int i = 0; i<n-2; i++) {
			if(arr1[i]==arr2[i]) {
				continue;
			}
			else {
				b = arr1[i];
				break loop2;
			}
	
		}
		System.out.println(a);
		System.out.println(b);

	}

}