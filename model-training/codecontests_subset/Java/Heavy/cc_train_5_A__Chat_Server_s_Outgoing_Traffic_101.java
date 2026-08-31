import java.io.*;
import java.util.*;

public class ChatServerOutgoingTraffic {

    public static void main( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String line = br.readLine();
        Set<String> set = new HashSet<String>();
        int cnt = 0;
        while ( line != null ) {
            if ( line.charAt(0) == '+' )
                set.add( line.substring(1) );
            else if ( line.charAt(0) == '-' )
                set.remove( line.substring(1) );
            else {
                String[] parts = line.split( "[:]" );
                if ( parts.length > 1 ) {
                    String msg = parts[1];
                    cnt += set.size() * msg.length();
                }
            }

            line = br.readLine();
        }
        System.out.println( cnt );
    }

}
