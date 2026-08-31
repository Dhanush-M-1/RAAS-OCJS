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
    static int year( String s )
    {
        if( s.length() >=5 )
            s=s.substring( 0, 4 );
        
        int x=Integer.parseInt( s );
        
        if(( x >= 2013)&&( x <= 2015))
            return x;
        
        else
            return -1;
    }
    
    static int month( String s )
    {
        if( s.length() != 2 )
            return -1;
        
        int x=Integer.parseInt(s);
        
        if( ( x>=1) && ( x<=12) )
            return x;
        
        else
            return -1;
    }
    
    static int day( String s, int month )
    {
        if( s.length() <2 )
            return -1;
        
        if( s.length() >= 3 )
            s=s.substring( s.length()-2, s.length());
        int x=Integer.parseInt(s);
        int MAX=days[month-1];
        
        if( ( x>MAX) || ( x<1 ) )
            return -1;
        
        else
            return x;
    }
    
    static void process( String dd, String mm, String yy )
    {
        boolean isValid=true;
        
        int year=year(yy);
        if( year<0)
            isValid=false;
        int month=month(mm);
        if( month<0)
            isValid=false;
        int day=-1;
        
        if( isValid)
            day=day(dd,month);
        
        if( day<0)
            isValid=false;
        
        if( !isValid )
            return;
        
        occ[year-2013][month-1][day-1]++;
        
        if( occ[year-2013][month-1][day-1] > CURRMAX )
        {
            DD=day;
            MM=month;
            YY=year;
            CURRMAX=occ[year-2013][month-1][day-1]; 
        }
        
               
    }

    static String[] firstThree( int cnt, String[] el ) // { cnt, dd, mm, yy }
    {
        String dd="",mm="",yy="";
        
        while( true )
        {
            if( cnt >=el.length)
                break;
            if( el[cnt].length()==0)
            {
                cnt++;
                continue;
            }
            dd=el[cnt++];
            
            if( cnt >=el.length)
                break;
            if( el[cnt].length()==0)
            {
                cnt++;
                continue;
            }
            mm=el[cnt++];
            
            if( cnt >=el.length)
                break;
            if( el[cnt].length()==0)
            {
                cnt++;
                continue;
            }
            yy=el[cnt++];
            break;
        }
        
        if( yy.length() == 0 )
            return null;
        String[] res=new String[4];
        res[0]=Integer.toString(cnt);
        res[1]=dd;
        res[2]=mm;
        res[3]=yy;
        return res;
    }
    static void solve() throws IOException
    {
         occ = new int[3][12][33];
        
        for( int[][] a:occ)
            for(int[] b:a)
                Arrays.fill( b,0);
        
        String[] el = inp.split( "-");
        int cnt=0;
        
        
        int MAX=-1;
        
        String[] temp=firstThree( cnt, el );
        cnt=Integer.parseInt( temp[0]);
        String dd, mm, yy;
        dd=temp[1];
        mm=temp[2];
        yy=temp[3];
        process( dd,mm,yy);
            
        while( true )
        {
            dd=mm;
            mm=yy;
            
            if( cnt >=el.length)
                break;
            if( el[cnt].length()==0)
            {
                cnt++;
                
                temp=firstThree( cnt, el );
                
                if( temp ==null )
                    break;
                
                cnt=Integer.parseInt( temp[0]);
                
                dd=temp[1];
                mm=temp[2];
                yy=temp[3];
                process( dd,mm,yy);
                continue;
                
            }
            
            else
            {
                yy=el[cnt++];
                process( dd,mm,yy);
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