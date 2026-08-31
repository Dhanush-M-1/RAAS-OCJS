import java.util.*;

public class Main {
	 public static void main (String[] args) {
		 Scanner in = new Scanner(System.in);
		 int n = in.nextInt();
		 int[] a = new int[4];
		 a[3] = 1;
		 boolean bool = false;
		 for(int i=0;i<n;i++) {
			 int x = in.nextInt();
			 if(a[x]==0) {
				 for(int j=1;j<4;j++) {
					 if(j!=x) {
						 if(a[j]==0) a[j] = 1;
						 else {
						 	if(a[j]==1) a[j] = 0;
						 }
					 }
				 }
			 }
			 if(a[x]==1) {
				 System.out.println("NO");
				 bool = true;
				 break;
			 }
		 }
		 if(bool==false) System.out.println("YES");
	 }
}


	   				 	 		 		 					 				   	