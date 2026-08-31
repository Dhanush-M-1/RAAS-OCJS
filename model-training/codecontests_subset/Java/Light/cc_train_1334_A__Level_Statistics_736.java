import java.util.Scanner;

public class que1 {

	public static void main(String[] args) {
    Scanner scn=new Scanner(System.in);
    int test=scn.nextInt();
    for(int t=0;t<test;t++){
    	int n=scn.nextInt();
    	int [][]arr=new int[n][2];
    	for(int i=0;i<n;i++){
    	 arr[i][0]=scn.nextInt();
    		 arr[i][1]=scn.nextInt();
    		
    	}
    	boolean b=true;
    	if(arr[0][0]<arr[0][1]){
    		System.out.println("NO");
    		continue;
    	}
    	for(int i=1;i<n;i++){
    	if(arr[i][1]<arr[i-1][1]||arr[i][0]<arr[i-1][0]){
    		b=false;
    		break;
    	}else if(arr[i][1]-arr[i-1][1]>arr[i][0]-arr[i-1][0]){
    		b=false;
    		break;
    	}
    	}
    	System.out.println(b?"YES":"NO");
    }
	}

}
