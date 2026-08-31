import java.util.*;
import java.io.*;
import java.math.*;


public class Main {


   public static void main( String[] args ) throws IOException{
      long inicio = System.currentTimeMillis();
      BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
      int n = Integer.parseInt( in.readLine() ), A = 0, I = 0;
      String l = in.readLine();
      for( int i = 0; i < n; i++ )
         if( l.charAt( i ) == 'A' ) A++;
         else if( l.charAt( i ) == 'I' ) I++;
     
      if( I == 0 )
         p( "" + A );
      if( I == 1 )
         p( "1" );
      if( I > 1)
         p( "0" ); 
      
      
      
      
   }
   public static void pln( String s ){
      System.out.println( s );
   }
   public static void p( String s ){
      System.out.print( s );
   }
}
