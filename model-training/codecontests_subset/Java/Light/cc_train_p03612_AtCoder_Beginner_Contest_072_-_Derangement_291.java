

import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int p[] = new int[n];
		for(int i = 0; i < n; i++){
			p[i] = sc.nextInt() - 1;
		}

		int count = 0;
		if(p[n - 1] == n - 1){
			int tmp = p[n - 2];
			p[n - 2] = p[n - 1];
			p[n - 1] = tmp;
			count++;

		}

		for(int i = 0; i < n - 1; i++){
			if(p[i] == i){
				int tmp = p[i];
				p[i] = p[i + 1];
				p[i + 1] = tmp;
				count++;
			}
		}

		System.out.println(count);
	}

}