import java.util.Scanner;

public class Main {
	  public static void main(String args[]) {
		    Scanner scanner = new Scanner(System.in);
		    
		    int N = scanner.nextInt();
		    int counter = 0;
		    for(int i = 0; i < N; i++) 
		    {
		    	int a = scanner.nextInt();
		    	counter = counter + a - 1;
		    }
		    System.out.println(counter);
		    scanner.close();}
		  }