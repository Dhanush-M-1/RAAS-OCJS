import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=0;
	  int[][] a=new int[n][2];
	  for(int i=0;i<n;i++){
	      a[i][0]=sc.nextInt();
	      a[i][1]=sc.nextInt();
	  }
	  for(int i=0;i<n;i++){
	      for(int j=0;j<n;j++){
	          if(a[i][0]==a[j][1]) c++;
	      }
	  }
		System.out.println(c);
	}
}
