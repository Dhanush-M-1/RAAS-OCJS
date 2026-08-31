import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int t= in.nextInt();
		int i,j;
		
		while(t-->0) {
			int count=0;
			int a=in.nextInt();
			int b=in.nextInt();
			int a1[]=new int[a];
			int a2[]=new int[b];
			for(i=0;i<a;i++) {
				a1[i]=in.nextInt();
			}
			
			for(i=0;i<b;i++) {
				a2[i]=in.nextInt();
			}
			
			for(i=0;i<a;i++) {
				
				for(j=0;j<b;j++) {
					
					if(a1[i]==a2[j]) {
						count++;
						System.out.println("YES");
						System.out.println(count+" "+a1[i]);
						break; }
					}
				if(count==1) {
					break;
				}
			}
			
			if(count==0) {
				System.out.println("NO");
			}
		}
			
		
		
			
		}	

	
		
		
		

	}
