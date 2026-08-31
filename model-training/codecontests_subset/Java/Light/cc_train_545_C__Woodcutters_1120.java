


import java .util.Scanner;
public class mainse {
	public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    int n=sc.nextInt();
    int arr[]=new int[n];
    int arr1[]=new int[n];
    int count=2;
    for(int i=0;i<n;i++){
    	arr[i]=sc.nextInt();
    	arr1[i]=sc.nextInt();
    	if(i>1){
    		if(arr[i-2]<arr[i-1]-arr1[i-1]){
    			count++;
    		}
    		else{
    			if(arr[i]>arr[i-1]+arr1[i-1]){
    				count++;
    				arr[i-1]=arr[i-1]+arr1[i-1];
    			}
    		}
    	}
    	
    	
    }
    if(n<2) System.out.println(n);
    else
    System.out.println(count);
	}
	
	
}
