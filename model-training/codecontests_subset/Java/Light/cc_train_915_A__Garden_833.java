import java.util.*;
public class p1{
	public static void main(String[] args){
		Scanner s =new Scanner (System.in);
		int b=s.nextInt();
		int l=s.nextInt();
		int arr[]=new int[b];
		for(int i=0;i<b;i++){
			arr[i]=s.nextInt();
		}
		int temp1=999999;
		for(int i=b-1;i>=0;i--){
			if(l%arr[i]==0){
				int temp=(l/arr[i]);
				if(temp1>temp)
					temp1=temp;
			}
		}
		System.out.println(temp1);
	}
}