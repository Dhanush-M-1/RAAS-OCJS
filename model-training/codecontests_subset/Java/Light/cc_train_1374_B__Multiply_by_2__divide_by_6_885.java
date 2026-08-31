import java.util.*;
public class S{
	public static void main(String[]args){
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		scan.nextLine();
		while(t--!=0){
			
			boolean flag=true;
			Long a=scan.nextLong();
			int count=0;
			while(a!=1){
				if(a%6==0){a/=6;count++;}
				else if(a%3==0){
					a/=3;count+=2;
				}
				else{flag=false;break;}
				
			}
				
				if(!flag){
				System.out.println(-1);continue;
			    }
				
			System.out.println(count);
			
			}
			
			
		}
	}
