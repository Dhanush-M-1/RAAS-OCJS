import java .util.*;
public class a{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String x=sc.next();
		int arr[]=new int[10];
		Arrays.fill(arr,0);
		for(int i=0;i<n;i+=1){
			if(x.charAt(i)=='8')
			arr[9]++;
			else if(x.charAt(i)=='9')
			arr[8]++;
			else
			arr[x.charAt(i)-'0']++;

		}
		int ans=0;
		int c=0;
		while(true){
			if(make(arr))
				c++;
			else
			{
				System.out.println(c);
				return;
			}

		}
	}
	static boolean make(int arr[]){
		if(arr[9]==0)
			return false;
		arr[9]--;
		int count=10;
		for(int i=0;i<10;i++){
			if(arr[i]<count){
				count-=arr[i];
				arr[i]=0;
			}
			else{
				arr[i]-=count;
				count=0;

			}
		}
		if(count==0)
			return true;
		return false;
	}
}