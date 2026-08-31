import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by slycer on 10/15/15.
 */
public class P1 {

    public static void main ( String [] args ) throws IOException {
        FastReader reader = new FastReader();
        int [] aux = reader.nextLineAsInt();
        int n = aux[0];
        int m = aux[1];
        boolean [] ok = new boolean[m+1];
        for ( int i=0; i<n; i++ ){
            int [] line = reader.nextLineAsInt();
            for ( int j = 1; j<line.length; j++ ){
                ok[ line[j] ] = true;
            }
        }
        for ( int i=1; i<=m; i++ ){
            if ( ok[i] == false ){
                System.out.println( "NO" );
                return ;
            }
        }
        System.out.println( "YES" );
    }


    public static class FastReader {
        BufferedReader reader;

        public FastReader (){
            reader = new BufferedReader( new InputStreamReader( System.in ) );
        }

        public int [] nextLineAsInt() throws IOException {
            String [] aux = reader.readLine().split( " " );
            int [] ret = new int[ aux.length ];
            for ( int i=0; i<aux.length; i++ ){
                ret[i] = Integer.valueOf( aux[i] );
            }
            return ret;
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }
    }
}
