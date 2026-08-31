import java.util.Scanner;
 
public class task{
 
     public static void main(String []args){
        Scanner in = new Scanner(System.in) ;
        
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            long minb =1000000007L;
        long maxa =0L;
        
            for(int j=0;j<n;j++){
                long a = in.nextLong() ;
                long b = in.nextLong()  ;
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