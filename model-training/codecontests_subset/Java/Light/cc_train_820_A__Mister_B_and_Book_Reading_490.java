
import java.util.Scanner ;


public class Main {

    
    public static void main(String[] args) {
        int c,v0,v1,a,l,read ;
        int day=0;
        
        Scanner input = new Scanner (System.in);
        
         c= input.nextInt(); // book page
         v0= input.nextInt();// frist day
         v1= input.nextInt();// limit
         a= input.nextInt();// increase
         l= input.nextInt();// refresh
         if(v0>=c)day=1;
         else{
         while(c>0){
             read=v0+day*a;
             if(read>v1)read=v1;
             day++;
             if(day==1)
             c=c-read;
             else c=c-(read-l);
             
             }}
         System.out.println(day);
         
         
    }
    
}