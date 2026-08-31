import java.util.*;

public class B977 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String a=sc.next();
		int a1=(int)a.charAt(0);
		char a12=a.charAt(0);
		
		int c1=0;
		char max1 = 0,max2 = 0,a112=0;
		//System.out.println(a1);
		for(int i=1;i<n-1;i++) {
			int c=0;
			int a11=(int)a.charAt(i);
			 a112=a.charAt(i);
	
				for(int j=i;j<n-1;j++) {
					int z=(int)a.charAt(j);
					int z1=(int)a.charAt(j+1);
					if(z==a1 && z1==a11)
						c+=1;
					if(c>c1) {
						c1=c;
						max1=a12;
						max2=a112;
					}
					
				}
				
				
			
			a1=a11;
			a12=a112;
			
			
		}
		if(max1==0 && max2==0) {
			System.out.println(a.substring(0,2));
		
		}
		else {
	
				System.out.print(max1);
				System.out.println(max2);
				
		}

	}
}