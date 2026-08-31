import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Scanner scanner;

	public static void main(String[] args) {
	    scanner = new Scanner(System.in);

        int N=gi();
        int[][] F=new int[N][10];
        int[][] P=new int[N][11];
        
        for (int i=0; i<N;i++) {
        	for (int j=0; j<10;j++) {
        		F[i][j]=gi();
        	}
        }
        for (int i=0; i<N;i++) {
        	for (int j=0; j<11;j++) {
        		P[i][j]=gi();
        	}
        }
        
        long max = Long.MIN_VALUE;
        for (int i=1; i<1024;i++) {
        	long sum=0;
        	for(int j=0; j<N; j++) {
        		int c=0;
        		for (int k=0; k<10;k++) {
        			if(F[j][k]==((i>>k) & 1) && F[j][k]==1) {
        				c++;
        			}
        		}
        		sum+=P[j][c];
        	}
        	if(sum>max) {
        		max=sum;
        	}
        }


	    System.out.println(max);

//	    if (isNumber(s1) && isNumber(s2) && s.charAt(a) == '-') {
//	    	System.out.print("Yes");
//	    }else {
//	    	System.out.print("No");
//	    }



	}

	public static long d(long n) {
		String a=String.valueOf(n);
		return (long)a.length();
	}

	// 文字列として入力を取得
	public static String gs() {
		return scanner.next();
	}

	// intとして入力を取得
	public static int gi() {
		return Integer.parseInt(scanner.next());
	}

	// longとして入力を取得
	public static long gl() {
		return Long.parseLong(scanner.next());
	}

	// doubleとして入力を取得
	public static double gd() {
		return Double.parseDouble(scanner.next());
	}
}