import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int t;
		int j=0,o=0;
		int js[]=new int[n];
		int os[]=new int[n];
		for(int i=0;i<n;i++) {
			t=reader.nextInt();
			if(t%2==1) {
				js[j]=t;
				j++;
			}else {
				os[o]=t;
				o++;
			}
		}
		Arrays.sort(js, 0, j);
		Arrays.sort(os, 0, o);
		int sum=0;
		if(o==0) {
			for(int i=0;i<j-1;i++)
				sum+=js[i];
		}else if(j==0) {
			for(int i=0;i<o-1;i++)
				sum+=os[i];
		}else if(o==j||o==j+1||j==o+1) {
			sum=0;
		}else if(o>j+1) {
			for(int i=0;i<o-j-1;i++) {
				sum+=os[i];
			}
		}else if(j>o+1) {
			for(int i=0;i<j-o-1;i++)
				sum+=js[i];
		}
		System.out.println(sum);
	}

}
		    	 					  	  	 				 	  	 	