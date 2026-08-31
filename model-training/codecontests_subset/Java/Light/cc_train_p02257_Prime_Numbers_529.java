import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int k,i;
		int s = 0;
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int array[] = new int[n];
		for(i=0;i<n;i++)array[i] = Integer.parseInt(in.next());
		for (k=0;k<n;k++){
			if (isprime(array[k])){
				s++;
		}
	}
		System.out.println(s);
}

	public static boolean isprime(int x) {
		int i = 3;
		if (x == 2)
				return true;
		if (x < 2 || x % 2 == 0 )
				return false;
		while (i <= Math.sqrt(x)){
			if (x % i == 0){
				return false;
			}
			i = i+2;
		}
		return true;
	}
}