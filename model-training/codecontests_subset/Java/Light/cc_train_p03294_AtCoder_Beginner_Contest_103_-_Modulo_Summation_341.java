import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    long N = Long.parseLong(scanner.next());
	    long[] A = new long[(int)N];

        long sum=0;
	    for (int i=0; i<N; i++) {
	    	sum+= Long.parseLong(scanner.next());
	    }


        System.out.print(sum-N);
	}

}