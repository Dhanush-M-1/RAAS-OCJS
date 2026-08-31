import java.util.*;
public class MyClass {
    public static void main(String args[]) {
    
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int t=a*c;
        int r=t-(b*c);
        if(r%b==0)
        System.out.println(r/b);
        else
        System.out.println((r/b)+1);
        
        sc.close();
    }
}