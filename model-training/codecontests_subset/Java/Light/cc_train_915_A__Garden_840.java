import java.util.*;

public class S915{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++){
			ar[i]=sc.nextInt();
		}
      int ans=500;int cnt=0;
		for(int i=0;i<n;i++){
			if(k%ar[i]==0 && ar[i]!=1){
				int an=k/ar[i];
			     ans=Math.min(ans,an);
			     cnt++;

			}

			
		}
		if(cnt==0){
			System.out.println(k);
		}
		else{
		System.out.println(ans);}
	}
}