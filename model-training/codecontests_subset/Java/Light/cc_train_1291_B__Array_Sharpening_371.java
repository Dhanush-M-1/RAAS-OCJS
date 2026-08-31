import java.util.Scanner;
 
public class B {
	public static void main(String[] args) {
		Scanner sc=new  Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int arr[]=new int[n];
			boolean flag=true;
			for(int i=0;i<n;i++){
				arr[i]=sc.nextInt();
				if(n==1){
				}else if(arr[i]>=i||arr[i]>=n-i-1){
					if(i==n/2){
						if(arr[i]!=arr[i-1]){}
						else if(arr[i]>i||arr[i]>n-i-1||arr[i-1]>i-1||arr[i-1]>n-i){}
						else{flag=false;}
					}
				}else{
					flag=false;
				}
			}
			System.out.println(flag?"Yes":"No");
		}
	}
}