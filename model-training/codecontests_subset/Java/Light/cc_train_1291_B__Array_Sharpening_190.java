import java.util.*;
public class makethemequal{
	public static void main(String []args){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		while(a-->0){
			int b=sc.nextInt(),d=0,p=0;
			int []ab=new int[b];
			for(int i=0;i<b;i++){
				ab[i]=sc.nextInt();
				if(ab[i]>=i || ab[i]>=b-i-1){
				d++;
			} 
			}
			if(b%2==0){
				if(ab[b/2-1]==b/2-1 && ab[b/2]==b/2-1)
					p++;
			}
			if(d==b && p==0){
				System.out.println("Yes");
			}
			else 
				System.out.println("No");
		}
		}
	}
	
		
	
