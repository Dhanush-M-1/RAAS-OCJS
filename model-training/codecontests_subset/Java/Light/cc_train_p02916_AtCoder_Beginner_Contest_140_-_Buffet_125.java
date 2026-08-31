import java.util.*;
public class Main{
	public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
	  int[] a = new int[n];
	  int[] b = new int[n];
	  int[] c = new int[n-1];
	  for(int i=0;i<n;i++){
	  	a[i]=sc.nextInt();
	  }
	  for(int i=0;i<n;i++){
	  	b[i]=sc.nextInt();
	  }
	  for(int i=0;i<n-1;i++){
	  	c[i]=sc.nextInt();
	  }
	  
	  int sat=b[a[0]-1];
	  for(int i = 1;i<n;i++){
	  	sat+=b[a[i]-1];
	  	if(a[i-1]+1==a[i])sat+=c[a[i]-2];
	  }
	  System.out.println(sat);
    }
}