import java.io.*;
import java.util.*;


public class cf519A{
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] aa = new int[n];
        int max = 0;
		int sum=0;
		for(int i=0;i<n;i++){
           aa[i] = sc.nextInt();
           sum+=aa[i];
           max = Math.max(max,aa[i]);
		}
        
        int i=max;

        while(true){
        	int nsum=0;
           for(int j=0;j<n;j++){
              nsum+=i-aa[j];
           }
           if(nsum>sum){
           	 System.out.println(i);
             break;
           }
           i++;
        }


	}
}