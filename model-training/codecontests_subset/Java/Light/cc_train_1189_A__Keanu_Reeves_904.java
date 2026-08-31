import java.util.*;
 
public class Main{   
	
	public static void main(String[] args){ 
		Scanner ak=new Scanner(System.in);
		int t,n;
		t=1;
		for(int p=0;p<t;p++){
			n=ak.nextInt();
			String s=ak.nextLine();
			s=ak.nextLine();
			if(n%2==1){
				System.out.println(1);
				System.out.println(s);
			}
			else{
				int z=0;
				for(int i=0;i<s.length();i++)
					if(s.charAt(i)=='0')
						z++;
				int o=s.length()-z;
				if(o!=z){
					System.out.println(1);
					System.out.println(s);
					return;
				}
				System.out.println(2);
				for(int i=0;i<s.length()-1;i++)
					System.out.print(s.charAt(i));
				System.out.println(" "+s.charAt(s.length()-1));
			}
		}
	}
} 