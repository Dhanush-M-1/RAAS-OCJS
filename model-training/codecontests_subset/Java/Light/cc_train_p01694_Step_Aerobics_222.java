import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(true) {
    		int n = sc.nextInt();
    		if(n==0) break;
        	String [] step = new String[n];
        	for(int i=0;i<n;i++) {
        		step[i] = sc.next();
        	}
        	int count = 0;
        	for(int i=0;i<n-1;i++) {
        		char c1 = step[i].charAt(1);
        		char c2 = step[i+1].charAt(1);
        		if(c1 == c2) {
        			count++;
        		}
        	}
        	System.out.println(count);
    	}
    }
}

