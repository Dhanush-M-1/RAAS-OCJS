import java.util.Scanner;

public class Main {
	    static String a;
	    public static void main(String[] args) {
	        Scanner stdIn = new Scanner(System.in);
	        int n = stdIn.nextInt();
	        int count = 0;
	        IN:for(int i = 0; i < n; i++) {
	            int x = stdIn.nextInt();
	            for(int j = 2; j*j <= x; j++) {
	                if(x % j == 0) continue IN;
	            }
	            count++;
	        }
	        System.out.println(count);
	    }
	}
