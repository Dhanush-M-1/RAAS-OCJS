import java.util.*;

public class Codechef1
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
		    arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int count1 = 0;
		int count2 = 0;
		for(int i=0; i<n; i++){
		    if(arr[i] == 100){
		        count1++;
		    }
		}
		for(int i=0; i<n; i++){
		    if(arr[i] == 200){
		        count2++;
		    }
		}
		if(count1==0 && count2%2==1){
		    System.out.print("NO");
		}else if(count2==0 && count1%2==1){
		     System.out.print("NO");
		}else if(count1%2==1 && count2%2==1){
		    System.out.print("NO");
		}else if(count1==1 && count2==1){
		    System.out.print("NO");
		}else if(count1%2==1 && count2%2==0){
		    System.out.print("NO");
		}else if(count1==2 && count2==1){
		    System.out.print("YES");
		}else if(count1==count2){
		    System.out.print("YES");
		}else{
		    System.out.print("YES");
		}
	}
}
