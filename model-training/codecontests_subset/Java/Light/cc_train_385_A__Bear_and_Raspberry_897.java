import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		int n,c,x;
		int [] arr=new int[120];
		Scanner mScanner=new Scanner(System.in);
		
		n=mScanner.nextInt();
		c=mScanner.nextInt();
		
		
		for(int i=0;i<n;i++){
			x=mScanner.nextInt();
			arr[i]=x;
		}
		mScanner.close();
		
		int max=0;
		boolean flag=false;
		for(int i=0;i<n-1;i++){
			if((arr[i]-arr[i+1])>max && arr[i]>arr[i+1]){
				max=arr[i]-arr[i+1];
				flag=true;
			}
		}
		int result;
		if(max-c<=0)
			result=0;
		else
			result=max-c;
		
		
		System.out.println(result);
		
				
		
		
		
		
		

}
}