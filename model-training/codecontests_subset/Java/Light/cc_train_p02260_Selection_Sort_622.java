import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.next());
        int[] ns = new int[n];
        for(int i=0;i<n;i++) {
        	ns[i] = Integer.valueOf(scan.next());
        }
        int change = 0;
        int minj=0;
        int cnt=0;
        for(int i=0;i<n;i++) {
        	minj = i; 
        	for(int j=i;j<n;j++) {
        		if(ns[j]<ns[minj]) {
        			minj = j;
        		}
        	}
        	if(minj!=i) {
	        	change = ns[minj];
	        	ns[minj] = ns[i];
	        	ns[i] = change;
	        	cnt++;
        	}
        }
        for(int i=0;i<n-1;i++) {
        	System.out.print(ns[i]+" ");
        }
        System.out.println(ns[n-1]);
        System.out.println(cnt);
        scan.close();
    }
}
