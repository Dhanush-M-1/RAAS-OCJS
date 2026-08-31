
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,a,b;
		a=b=0;
		n=sc.nextInt();
		for(int i=0;i<n;i++){
			int k=sc.nextInt();
			if(k==200){
				a++;
			}
			else{
				b++;
			}
		}
	//	System.out.println(a+" "+b);
		if(a%2==0&&b%2==0){
			System.out.println("YES");
		}
		else if(a%2==1&&b>=2&&b%2==0){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}

}

   	 	 		  			 	    		 	  	 		