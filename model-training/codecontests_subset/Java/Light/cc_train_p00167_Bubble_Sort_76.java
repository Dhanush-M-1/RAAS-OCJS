import java.util.Scanner;
//import java.io.*;
//import java.util.Arrays;
public class Main {
	public static void main(String[] args) throws java.io.IOException {
		Scanner scan = new Scanner(System.in);
		//InputStreamReader is = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(is);
		int n  = scan.nextInt();
		while(n != 0){
			int num[] = new int[n];
			int cun = 0;
			for(int i = 0 ; i < n ; i++){
				num[i] = scan.nextInt();
			}
			for(int i = n-1 ; i > 0 ; i--){
				for(int j = 0 ; j < i ; j++){
					if(num[j] > num[j+1]){
						int cen = num[j];
						num[j] = num[j+1];
						num[j+1] = cen;
						cun++;
					}
				}
			}
			System.out.println(cun);
			n = scan.nextInt();
		}
	}
}