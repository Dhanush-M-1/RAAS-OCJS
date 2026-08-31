import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);

	/* 入力 */
	int n = scan.nextInt();
	int m = scan.nextInt();
	int[] a = new int[n];
	int[] b = new int[n];
	int[] c = new int[m];
	int[] d = new int[m];
	for(int i = 0; i < n; i++){
	    a[i] = scan.nextInt();
	    b[i] = scan.nextInt();
	}
	for(int i = 0; i < m; i++){
	    c[i] = scan.nextInt();
	    d[i] = scan.nextInt();
	}

	for(int i = 0; i < n; i++){
	    int min = Integer.MAX_VALUE;
	    int index = -1;
	    for(int j = 0; j < m; j++){		
		if(min > Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j])){
		    min = Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
		    index = j;
		}
	    }
	    System.out.println(index+1);
	}
    }
}
	    
