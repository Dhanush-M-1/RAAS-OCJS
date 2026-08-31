import java.util.Arrays;
//import java.lang.*;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		try(Scanner in = new Scanner(System.in)){
			int [] count = new int [200100];
			int [] sort_count = new int [200100];
			int n,k,i,x,temp;
			n=in.nextInt();
			k=in.nextInt();
			int [] num = new int [n]; 
			for(i=0; i<n; i++)
				num[i]=in.nextInt();
			Arrays.sort(num);
			int min=Integer.MAX_VALUE;
			for( i=0; i<n; i++){
				temp=0;
				x=num[i];
				while(x!=0){
					count[x]++;
					sort_count[x]+=temp;
					if(count[x]==k)	{
						if(min>sort_count[x]) {
							min=sort_count[x];
							break;
						}		
					}
					temp++;
					x/=2;
				}
			}
			System.out.printf("%d",min);    
		}
	}
}

	    					 		  			  			 		