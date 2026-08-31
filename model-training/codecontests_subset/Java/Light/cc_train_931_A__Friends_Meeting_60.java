import java.util.*;

public class P931A{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if(b<a){
			int temp = b;
			b = a;
			a = temp;
		}


		int tired = 0;
		int counter = 1;
		while(a!=b){
			b--;
			tired+=counter;
			if(b==a) break;
			a++;
			tired+=counter;
			counter++;
		}

		System.out.println(tired);
	}
}
