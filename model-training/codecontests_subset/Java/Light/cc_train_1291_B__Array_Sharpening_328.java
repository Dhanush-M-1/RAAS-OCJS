import java.util.*;
public class b_prblm {

	public static boolean sol(int[] arr){
		if(arr.length==1)
			return true;
		if(arr.length==2){
			if(arr[0]>0 || arr[1]>0)
				return true;
		}
			int lp=-1;
			for(int i=0;i<arr.length;i++){
				if(lp<arr[i]){
					lp++;
				}else
					break;
			}
			int rp=-1;
			for(int i=arr.length-1;i>=0;i--){
				if(rp<arr[i]){
					rp++;
				}
				else
					break;
			   if(lp>=arr.length-rp-1){
					return true;
				}
			}
			return false;
		
	}
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0){
			int n=scn.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			boolean res=sol(arr);
			if(res)
				System.out.println("Yes");
			else{
				System.out.println("No");
			}
		}
			
		
			
	}

	}