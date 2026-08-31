import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      int[] c = new int[n];
      for(int i=0; i<n; i++) {
    	  a[i]=scan.nextInt()-1;
      }
      for(int i=0; i<n; i++) {
    	  b[i]=scan.nextInt();
      }
      for(int i=1; i<n; i++) {
    	  c[i]=scan.nextInt();
      }
      int sum =0;
      for(int i=0; i<n; i++) {
        sum = sum+b[a[i]];
        if(i!=0 && a[i]-a[i-1]==1) {
          sum = sum +c[a[i]];
        }
      }
      System.out.println(sum);
    }
}