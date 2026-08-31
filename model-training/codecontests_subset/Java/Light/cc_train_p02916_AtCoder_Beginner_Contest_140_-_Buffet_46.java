import java.util.*;

public class Main{
	  public static void main(String[]args){
	  Scanner sc = new Scanner(System.in);
		  int point = 0;
		  int number = sc.nextInt();
		  int[][] a = new int[number][3];

		  for(int i=0; i<2; i++) {
			  for(int x=0; x<number; x++) {
				  a[x][i] = sc.nextInt();
			  }
		  }
		  for(int i=0; i<number-1; i++) {
			  a[i][2] = sc.nextInt();
		  }
		  for(int i=0; i<number; i++) {
			  point += a[a[i][0]-1][1];
			  if(i<number-1) {
				  if(a[i][0]+1 == a[i+1][0]) {
					  point += a[a[i][0]-1][2];
				  }
			  }
		  }
		  System.out.println(point);
  }
}