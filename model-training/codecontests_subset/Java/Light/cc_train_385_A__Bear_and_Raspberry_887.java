import java.util.Scanner;

public class Bear{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int c=sc.nextInt();
		int[] arr=new int[n];

		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
        
        int max=0;
		for(int i=0;i<n-1;i++){
			if((arr[i]-arr[i+1])>max){
				max=arr[i]-arr[i+1];
			}
		}
        if(max<c){
        	System.out.println(0);
        }else{
		System.out.println(max-c);
	    }
	}
}