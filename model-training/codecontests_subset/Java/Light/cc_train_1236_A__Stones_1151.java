import java.util.*;
public class Stones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
		    while(t-->0)
		    {
		        int a=sc.nextInt();
		        int b=sc.nextInt();
		        int c=sc.nextInt();
		        int m=0,x=0,y=0;
		        if(c>=2&&b>=1)
		        {
		        m=Math.min(b,c/2);
		        b=b-m;
		        x=m*3;
		        }
		        
		        if(b>=2&&a>=1)
		        {
		            m=Math.min(a, b/2);
		            a=a-m;
		            y=m*3;
		    
		        }
		    System.out.println(x+y);
		    }
		    
	}

}
