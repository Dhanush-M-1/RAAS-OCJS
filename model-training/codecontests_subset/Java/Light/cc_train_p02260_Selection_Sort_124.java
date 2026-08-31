import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 0;
		int count=0;
		long[] array = new long[n];

		for(int i=0;i<n;i++) {
			array[i]=sc.nextLong();

		}
		for(int i=0;i<n;i++) {
			min = i;
			for(int j=i+1;j<n;j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			if(min!=i) {
				long temp = array[i];
				array[i] = array[min];
				array[min] = temp;
				count ++;
			}
			
		}

		for(int i=0;i<n;i++) {
			if(i!=n-1) {
				System.out.print(array[i] + " ");
			}else {
				System.out.println(array[i]);
			}
		}

		System.out.println(count);

	}

	public static long max(long[] array,int j) {
		long temp,max=-9999999;
		for(int i=j+1;i<array.length;i++) {
			temp = array[i] - array[j];
			if(temp > max) {
				max = temp;
			}
		}
		return max;
	}
}

