import java.util.Scanner;
/**
 *
 * @author ahmad97
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
    Scanner console  = new Scanner (System.in) ;
       int n = console.nextInt() ; 
       double m = console.nextInt() ;
       int x[] = new int [n] ;
       int mi=1000000000 ; 
       for (int i=0 ; i<x.length ; i++){
           x[i]=console.nextInt() ; 
       }
       for (int i=0 ; i<x.length ; i++){
        String a = (m/((double)x[i]))+"" ;
        int count = 0 ; 
        String f = "" ; 
        int countt = 0 ; 
        for (int j=0 ; j<a.length() ; j++){
            if (a.charAt(j)=='.'){
                f="." ; 
            }
            else if (f.contains(".")){
                countt ++ ; 
                if (a.charAt(j)=='0'){
                    count ++;
                }
            }
        }
        if (countt==count){
            if ((m/x[i])<mi){
            mi=(int) (m/x[i]) ; 
        }
        }
       }
        System.out.println(mi);
   }
}