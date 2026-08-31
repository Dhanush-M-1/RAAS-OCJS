import java.util.*;
import java.io.*;
public class cdf1{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        int i,t,n,x=1,y=2,z=3,p=0;
        t=sc.nextInt();
        boolean b=true;
        for(i=1;i<=t;i++){
            n=sc.nextInt();
            if(n!=x&&n!=y){
                b=false;
                break;
            }
            if(n==x)
            p=y;
            if(n==y)
            p=x;
            x=n;
            y=z;
            z=p;
        }
        if(b)
        System.out.println("YES");
        else
        System.out.println("NO");
    }
}