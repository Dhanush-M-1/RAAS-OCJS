import java.util.Scanner;

public class Main {

	public static boolean isprime(int x){
	  if (x == 2) {
	    return true;
	  }
	  if(x < 2  ||x %2==0) {
	    return false;
	  }
	 int i = 3;
	  while (i <= Math.sqrt(x)) {
	    if( x % i==0) {
	      return false;
	    }
	    i = i + 2;
	  }
	 return true;

	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int count=0;
		for(int i=0;i<n;i++) {
			int num=scanner.nextInt();
			if(isprime(num)==true) {
				count=count+1;
			}
		}
		System.out.println(count);
	}
}

