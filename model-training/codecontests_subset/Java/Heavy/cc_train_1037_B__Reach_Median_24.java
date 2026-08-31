import java.util.*;


public class JavaApplication8 {

  
    public static void main(String[] args) {
       //System.out.println(checkIBit(15,4)) ;
    
        Scanner in = new Scanner(System.in) ;
        int n = in.nextInt() ; 
        long  s = in.nextLong()  ;
        long[] a = new long[n] ;
        
        for(int i=0;i<n;i++){
            a[i] = in.nextLong() ;
        }
        
        Arrays.sort(a);
        long sum = 0;
        
        if(s > a[n / 2]){
            int i = n /2 ;
            while(i<n && s > a[i]){
                sum += s - a[i] ;
                i ++;
            }
        }else if(s < a[n /2]){
            int i = n /2 ;
            while(i>=0 && s < a[i]){
                sum += a[i] - s ;
                i--;
            }
        }else{
            sum = 0;
        }
        System.out.println(sum) ;
    }
}