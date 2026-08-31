import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0){
			int sum=0;
			int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
			while(b>=1 && c>=2){
				b-=1;
				c-=2;
				sum+=3;
			}
			while(a>=1 && b>=2){
				a-=1;
				b-=2;
				sum+=3;
			}
			System.out.println(sum);
		}
	}
}
   	 	 	 	 	  	 		 	 		   	 			