import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		String[] str = (br.readLine()).split(" ");
		for (int i = 0; i<n ; i++ ) {
			num[i] = Integer.parseInt(str[i]);
		}
		int count = 0;
		for (int i = 0 ; i<num.length ; i++  ) {
			int mini = i;
			for (int j = i; j<num.length ; j++ ) {
				if ( num[j] < num[mini]) {
					mini = j;
				}
			}
			if (i != mini) {
				int work = num[i];
				num[i] = num[mini];
				num[mini] = work;
				count++;
			}
		}
		for (int i = 0; i<num.length ; i++ ) {
			if ( i == num.length-1) {
				System.out.println(num[i]);
			}else{
				System.out.print(num[i] + " ");
			}
		}
		System.out.println(count);
	}
}