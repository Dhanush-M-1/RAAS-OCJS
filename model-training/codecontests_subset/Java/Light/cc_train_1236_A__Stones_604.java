import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		 int T=sc.nextInt();
		 while(T-->0){
			 
			 long a[]=new long[3];
			 for(int i=0;i<3;i++){
				 a[i]=sc.nextLong();
			 }
			 long q=0;
			 long sum=0;
			 while(a[1]>0&&a[2]>1){
				 a[1]--;
				 a[2]-=2;
				 q++;
			 }
			 while(a[0]>0&&a[1]>1){
				 a[0]--;
				 a[1]-=2;
				 q++;
			 }
			 System.out.println(q*3);
			 
		 }
		 
		 
	}

}
