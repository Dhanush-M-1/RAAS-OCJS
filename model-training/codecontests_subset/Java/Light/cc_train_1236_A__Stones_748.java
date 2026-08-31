import java.util.*;
public class main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		for(int i=0;i<N;i++){
		int sum=0;
		int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
			while(y>=1 & z>=2){
				sum=sum+3;
				y-=1;
				z-=2;
			}
			while(x>=1 & y>=2){
				sum+=3;
				x-=1;
				y-=2;
			}
		
		System.out.println(sum);
		}
	}

}

	 	 			  		  	 								 						