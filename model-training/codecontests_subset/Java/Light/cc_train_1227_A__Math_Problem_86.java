import java.util.Scanner;

public class HelloWorld{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in) ;
        
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            long minb =1000000007L;
        long maxa =0L;
        
            for(int j=0;j<n;j++){
                long a = sc.nextLong() ;
                long b = sc.nextLong()  ;
                if(a > maxa ){
                    
                    maxa = a;}
                if(b<minb){
                    
                       
                    minb= b;
                }
            }
            
            //System.out.println(maxa + " " + minb);
            if(n==1 || minb >= maxa)
                System.out.println(0);
            else
                System.out.println( Math.abs(maxa - minb) ) ;
        
    
     }
}
}