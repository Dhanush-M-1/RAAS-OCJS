import java.util.*;
public class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      int[] c = new int[m];
      int[] d = new int[m];
      int[] p = new int[n];
      int min = 1000000000;
      for(int i = 0;i < n;i++){
      	a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }
      for(int i = 0;i < m;i++){
      	c[i] = sc.nextInt();
        d[i] = sc.nextInt();
      }
      for(int i = 0;i < n;i++){
      	for(int j = m-1;j >= 0;j--){
        	min = Math.min(Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]),min);
          if(min == Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j])){
            p[i]=j+1;
          }
        }
        System.out.println(p[i]);
        min = 1000000000;
      }
    }
}