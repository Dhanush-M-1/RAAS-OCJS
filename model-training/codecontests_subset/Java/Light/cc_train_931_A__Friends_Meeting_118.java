import java.util.*;
public class MyClass {
    public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int k=sc.nextInt();
    int t=0,d1,d2;
    double avg=0.0;
    avg=(n+k)/2.0;
    int m;      double f;
    m=(int)avg;
    f=avg-m;
       if(f!=0.0) 
       m=m+1;
       
        d1=n-m;
        if(d1<0)
        d1=d1*(-1) ;
        d2=m-k;
        if(d2<0)
        d2=d2*(-1);
        t=((d1*(d1+1))/2)+((d2*(d2+1))/2) ;
    
    System.out.println(t);
    
    }}
    