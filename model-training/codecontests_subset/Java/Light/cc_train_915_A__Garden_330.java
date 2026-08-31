import java.util.*;
public final class code1{
	public static void main(String arg[]){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] arr=new int[n];
		int ans=0;
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
			
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++){
			if(k%arr[i]==0){
				ans=k/arr[i];
			}
		}
		if(ans==0){
			ans=k;
		}
		System.out.println(ans);
	}
}