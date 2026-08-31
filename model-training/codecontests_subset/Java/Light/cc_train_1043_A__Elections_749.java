import java.util.*;
public class Solution{
         public static void main(String[] args){
		    Scanner sc=new Scanner(System.in);
		    int N=sc.nextInt();
			int max=0,sum=0;
			for(int i=0;i<N;i++){
				int a=sc.nextInt();
				sum+=a;
				if(max<a)
					max=a;
			}
			int result=0;
			for(int i=max;;i++){
				int run=i*N-sum;
				if(run>sum){
					result=i;
					break;
				}
			}
		    System.out.println(result);
		}
    }