  
import java.util.*; 
public class Ex {
public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in); 
        int n=sc.nextInt();
        int g=sc.nextInt();
        int[] arr=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
        	arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++){
        	if(arr[i+1]<arr[i]){
              int diff=arr[i]-arr[i+1];
              if(diff>max){
              	max=diff;
              }
        	}
        }
        if(max-g>=0 && max>0){
        	max=max-g;
        }
        else{
        	max=0;
        }
        System.out.println(max);
    }
} 
