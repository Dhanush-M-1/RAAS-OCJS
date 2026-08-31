import java.util.* ;
import java.lang.* ;
import java.io.* ;

public class Solution {
    
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in) ;
        int n = in.nextInt() ;
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int[] host = new int[n] ;
        for ( int i = 0 ; i < n ; ++i ) {
            host[i]=in.nextInt(); int y=in.nextInt() ;
            if ( map.get(y) == null ) {
                map.put(y,0) ;
            }
            map.put(y,map.get(y)+1);
        }
        int ans = 0;
        for( int i : host ) {
            if ( map.get(i)!=null ) {
                ans += map.get(i) ;
            }
        }
        
        System.out.println(ans) ;
        
    }
    
}