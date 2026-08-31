import java.util.Scanner;
 
/**
 *
 * @author nourhan.mohamed
 */
 public class RuntimeExec {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){ 
        long n , p ,x=0,y=0,z=0 , result ;
        int w, d ;
        n = sc.nextLong();
        p = sc.nextLong();
        w = sc.nextInt();
        d = sc.nextInt();
        
        if(n*w < p || (d > p && p!=0) ){
            System.out.println(-1);
            return;
        }
        if(p == 0){
            System.out.println(0+" "+0+" "+n);
            return;   
        }
        
        y = 0 ;
        x = (long) (p/w) ; 
        z= n-(x+y); 
        result = (x*w)+(y*d);
        
        while (result < p ){
            y++;
            x = (long) (( (p - (y*d) )/w) ) ; 
            z= n-(x+y); 
            result = (x*w)+(y*d);
            if(y>=w)
            	break;
        }
        
        if(x <=0 && y<=0 && z<=0){
            System.out.println(-1);
        }else if( result != p){
            System.out.println(-1);
        }
        else{
            System.out.println(x+" "+y+" "+z);
        }
    }
}