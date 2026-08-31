import java.util.Scanner;

public class Main { 
	
	public static void main(String args[]) 
	{ 
		Scanner input=new Scanner(System.in);
		int n=input.nextInt(),sum,temp=0;
		for(int i=0;i<3;i++) {
			sum=0;
			for(int k=0;k<n;k++) {
				sum+=input.nextInt();
			}
			if(i>0) {
				System.out.println(temp-sum);
			}
			n--;
			temp=sum;
		}
	} 
} 
