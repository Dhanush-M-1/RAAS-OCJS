import java.util.Scanner;

public class WizardsandDemonstration {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
       int y=sc.nextInt();
       int p=sc.nextInt();
       int r=0;
       if((p*n)%100==0)
                r=p*n/100;
       else
               r= ((int)p*n/100)+1;
       
       if(r>y){
           System.out.println(r-y);
       }
       else
         System.out.println("0");
     }
}