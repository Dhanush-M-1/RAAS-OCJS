import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class TC
{
    static int[][][] occ;
    static String inp;
    static int[] days = { 31,28,31,30,31,30,31,31,30,31,30,31};
    static int DD, MM, YY, CURRMAX;
    
    static void solve() throws IOException
    {
         occ = new int[3][12][33];
         CURRMAX=-1;
         
        for( int[][] a:occ)
            for(int[] b:a)
                Arrays.fill( b,0);
        
        for( int i=0; i<inp.length()-9; i++ )
        {
            if( Character.isDigit( inp.charAt(i)) && Character.isDigit( inp.charAt(i+1)) && ( inp.charAt(i+2) =='-')
                    && Character.isDigit( inp.charAt(i+3)) && Character.isDigit( inp.charAt(i+4)) && 
                    ( inp.charAt(i+5) =='-')  && Character.isDigit( inp.charAt(i+6)) && Character.isDigit( inp.charAt(i+7)) 
                    && Character.isDigit( inp.charAt(i+8)) && Character.isDigit( inp.charAt(i+9)))
            {
                int dd= Integer.parseInt( inp.substring(i, i+2 ) );
                int mm= Integer.parseInt( inp.substring(i+3, i+5 ) );
                int yy= Integer.parseInt( inp.substring(i+6, i+10 ) );
                
                if( ( yy >= 2013 ) && ( yy <= 2015 ) )
                {
                    if( ( mm >= 1 ) && ( mm <= 12 ) )
                    {
                        if( ( dd >= 1 ) && ( dd <= days[mm-1] ) )
                        {
                            occ[yy-2013][mm-1][dd-1]++;
                            
                            if( occ[yy-2013][mm-1][dd-1] > CURRMAX )
                            {
                                CURRMAX=occ[yy-2013][mm-1][dd-1];
                                DD=dd;
                                MM=mm;
                                YY=yy;
                            }
                        }
                    }
                }
            }
                
        }
    
        // print result
        
        BufferedWriter out=new BufferedWriter( new OutputStreamWriter( System.out ));
        
        if( DD<10)
            out.write( "0" + Integer.toString(DD) +"-");
        
        else
            out.write( Integer.toString(DD) +"-");
        
        if( MM<10)
            out.write( "0" + Integer.toString(MM) +"-");
        
        else
            out.write( Integer.toString(MM) +"-");
        
        out.write( Integer.toString(YY) +"\n");
        out.close();
        
    }
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        
        inp=br.readLine();
        solve();
    }
}