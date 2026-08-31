import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        long t=sc.nextLong();
        
        for(long i=0;i<t;i++)
        {
            long n=sc.nextLong();
            
            int count=0,p=0;
            
            while(n>1 && count<2)
            {
                if(n%6==0)
                {
                    n=n/6;
                    p=p+1;
                    count=0;
                }
                else{
                    n=n*2;
                    p=p+1;
                    count +=1;
                }
                
            }
            
            if(n==1)
            System.out.println(p);
            else
            System.out.println("-1");

        }
	}
}
