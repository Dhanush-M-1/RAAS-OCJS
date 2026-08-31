import java.io.*;
import java.util.*;

public class Main {
    long MAXP = (int)Math.sqrt(1e13 );
    boolean bprimes[ ] = new boolean[ (int)MAXP + 1 ];
    int plen;
    int primes[ ] = new int[ 1 << 20 ];
    void pre( ) {
        Arrays.fill( bprimes, true );
        for ( int i = 2; i <= MAXP; ++i ) {
            if ( bprimes[ i ] ) {
                primes[ plen++ ] = i;
                if ( ( long )i * i <= MAXP ) {
                    for ( int j = i * i; j <= MAXP; j += i ) {
                        bprimes[ j ] = false;
                    }
                }
            }
        }
        //debug( plen );
    }
    public void solve( ) throws Throwable {
        pre( );
        long n = in.nextLong( );
        long temp = n;
        int total = 0;
        boolean once = false;
        List< Long > factors = new ArrayList< Long >( );
        for ( int i = 0; i < plen && primes[ i ] <= n / primes[ i ]; ++i ) {
            long div = primes[ i ], count = 0;
            if ( n % div == 0 ) {
                factors.add( div );
                while ( n > 1 && n % div == 0 ) {
                    n /= div;
                    once = true;
                    ++total;
                }
            }

        }
        if ( n > 1 ) {
            factors.add( n );
            ++total;
        }

        //debug( factors );
        if ( !once ) {
            out.println( 1 );
            out.println( 0 );
            return;
        }

        if ( total == 2 ) {
            out.println( 2 );
            return;
        }
        out.println( 1 );
        out.println( factors.size( ) < 2 ? factors.get( 0 ) * factors.get( 0 )  : factors.get( 0 ) * factors.get( 1 ) );

    }

    public void run( ) {
        in = new FastScanner( System.in );
        out = new PrintWriter( new PrintStream( System.out ), true );

        try {
            solve( );
            out.close( );
            System.exit( 0 );
        } catch( Throwable e ) {
            e.printStackTrace( );
            System.exit( -1 ); 
        }
    }


    public void debug( Object...os ) {
        System.err.println( Arrays.deepToString( os ) );
    }

    public static void main( String[ ] args ) {
        ( new Main( ) ).run( );
    }



    private FastScanner in;
    private PrintWriter out;

    private static class FastScanner {
        private int charsRead;
        private int currentRead;
        private byte buffer[ ] = new byte[ 0x1000 ];
        private InputStream reader;

        public FastScanner( InputStream in ) {
            reader = in;
        }

        public int read( ) {
            if ( charsRead == -1 ) {
                throw  new InputMismatchException( );
            }

            if ( currentRead >= charsRead ) {
                currentRead = 0;
                try {
                    charsRead = reader.read( buffer );

                } catch( IOException e ) {
                    throw new InputMismatchException(  );
                }

                if ( charsRead <= 0 ) {
                    return -1;
                }
            }

            return buffer[ currentRead++ ];
        }

        public int nextInt( ) {
            int c = read( );

            while ( isWhitespace( c ) ) {
                c = read( );
            }

            if ( c == -1 ) {
                throw new NullPointerException( );
            } 

            if ( c != '-' && !( c >= '0' && c <= '9' ) ) {
                throw new InputMismatchException( );
            }

            int sign = c == '-' ? -1 : 1;
            if ( sign == -1 ) {
                c = read( );
            }

            if ( c == -1 || !( c >= '0' && c <= '9' ) ) {
                throw new InputMismatchException( );
            }

            int ans = 0;
            while ( !isWhitespace( c )  && c != -1 ) {
                if ( !( c >= '0' && c <= '9' ) ) {
                    throw  new InputMismatchException( );
                }
                int num = c - '0';
                ans = ans * 10 + num;
                c = read( );
            }

            return ans * sign;
        }

        public long nextLong( ) {
            int c = read( );

            while ( isWhitespace( c ) ) {
                c = read( );
            }

            if ( c == -1 ) {
                throw new NullPointerException( );
            }

            if ( c != '-' && !( c >= '0' && c <= '9' ) ) {
                throw new InputMismatchException( );
            }

            int sign = c == '-' ? -1 : 1;
            if ( sign == -1 ) {
                c = read( );
            }

            if ( c == -1 || !( c >= '0' && c <= '9' ) ) {
                throw new InputMismatchException( );
            }

            long ans = 0;
            while ( !isWhitespace( c )  && c != -1 ) {
                if ( !( c >= '0' && c <= '9' ) ) {
                    throw  new InputMismatchException( );
                }
                int num = c - '0';
                ans = ans * 10 + num;
                c = read( );
            }

            return ans * sign;
        }



        public boolean isWhitespace( int c ) {
            return  c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == -1;
        }

        public String next( ) {
            int c = read( );
            StringBuffer ans = new StringBuffer( );

            while ( isWhitespace( c ) && c != -1 ) {
                c  = read( );
            }

            if ( c == -1 ) {
                return null;
            }

            while ( !isWhitespace( c ) && c != -1 ) {
                ans.appendCodePoint( c );
                c = read( );
            }

            return ans.toString( );

        }

               
        public String nextLine( ) {
            String ans = nextLine0( );

            while ( ans.trim( ).length( ) == 0 ) {
                ans = nextLine0( );
            }

            return ans;
        }
        
        private String nextLine0( ) {
            int c = read( );
            if ( c == -1 ) {
                return null;
            }
            StringBuffer ans = new StringBuffer( );
            while ( c != '\n' && c != '\r' && c != -1 ) {
                ans.appendCodePoint( c );
                c = read( );
            }

            return ans.toString( );

        }


       
        public double nextDouble( ) {
            int c = read( );
            while ( isWhitespace( c ) ) {
                c = read( );
            }

            if ( c == -1 ) {
                throw new NullPointerException( ); 
            }

            if ( c != '.' && c != '-' && !( c >= '0' && c <= '9' ) ) {
                throw new InputMismatchException( );
            }

            int sign = c == '-' ? -1 : 1;
            if ( c == '-' ) {
                c = read( );
            }
            double ans = 0;
            while ( c != -1 && c != '.' && !isWhitespace( c ) ) {
                if ( !( c >= '0' && c <= '9' ) ) {
                    throw new InputMismatchException( );
                }

                int num = c - '0'; 
                ans = ans * 10.0 + num;
                c = read( );
            }

            if ( !isWhitespace( c ) && c != -1 && c != '.' ) {
                throw new InputMismatchException( );
            }

            double pow10 = 1.0;

            if ( c == '.' ) {
                c = read( );
            }

            while ( !isWhitespace( c ) && c != -1 ) {
                pow10 *= 10.0;

                if ( !( c >= '0' && c <= '9' ) ) {
                    throw new InputMismatchException( );
                }
                int num = c - '0';
                ans = ans * 10.0 + num; 
                c = read( );
            }

            return ans * sign / pow10;
        }
    }

}
