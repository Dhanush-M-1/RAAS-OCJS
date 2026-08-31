import java.util.Scanner;

public class Main{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
        
     int n=sc.nextInt();
        String s=sc.next();
        int num0=0;
        int num1=0;
        for(int i=0;i<n;i++)
        {
            char chr1=s.charAt(i);
            if(chr1=='0')
            {
                num0++;
            }
            else
            {
                num1++;
            }
        }
        if(num0==num1)
        {
            System.out.print(2+"\n");
            System.out.print(s.substring(0,n-1)+" "+s.substring(n-1)+"");
        }
        else
        {
            System.out.print(1+"\n");
            System.out.println(s+"");
        }
 
        
    }
}
 