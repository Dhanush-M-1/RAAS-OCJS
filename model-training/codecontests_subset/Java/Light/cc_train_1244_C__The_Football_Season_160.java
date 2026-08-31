import java.util.Scanner;

public class ArrayList{
public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    long sum=0;
    long p=sc.nextLong();
    long q=sc.nextLong();
   long t=sc.nextLong();
   long r=sc.nextInt();
  for (long i=0;i<t;i++){
     if(((q-i*r)%t==0)&&((q-i*r)/t>=0)&&(p-i-(q-i*r)/t>=0)){
         long m=(q-i*r)/t;
         long n=i;
         long o=p-m-n;
         System.out.println(m+" "+n+" "+o);
         sum=1;
         break;
     }
}
     if(sum==0){
         System.out.println("-1");
     }
    }
}

        