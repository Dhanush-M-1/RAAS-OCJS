
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static PrintWriter out =new PrintWriter(System.out);
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int array[] = new int[n];
    	for(int i=0;i<n;i++) {
    		array[i] = sc.nextInt();
    	}
    	slection(array,n);
    	out.print(array[0]);
    	for(int i=1;i<n;i++) {
    		out.print(" "+array[i]);
    	}
    	out.println();
    	out.println(cnt);
    	out.flush();
    }
    
    static void slection(int[] a,int n) {
    	for(int i=0;i<n-1;i++) {
    		int minj = i;
    		for(int j=i;j<n;j++) {
    			if(a[j]<a[minj]) 
    				minj = j;
    		}
    		if(a[minj]!=a[i]) {
    			cnt++;
    			int tmp = a[minj];
    			a[minj] = a[i];
   				a[i] = tmp;
    		}
    	}
    }
    	
}
