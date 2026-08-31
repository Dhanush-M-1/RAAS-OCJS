import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution implements Runnable
{
    private void solve() throws IOException
    {
    	//max_int > 2 * 10^9
    	
    	//int n = nextInt();
    	
    	int l = nextInt();
    	int r = nextInt();
    	
    	if (l == r)
    		writer.print(l);
    	else
        	writer.print(2);
    	
    }
    
    private List<Integer> primeFact(int n) {
	     List<Integer> factors = new ArrayList<Integer>();
	     
	     for (int i = 2; i <= n / i; i++) {
             while (n % i == 0) {
                 factors.add(i);
                 n /= i;
             }
	     }
	     if (n > 1) 
	    	 factors.add(n);
	     
	     return factors.stream().distinct().collect(Collectors.toList());
    }
    
    private List<Integer> findPrimes(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;
         
        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
            	list.add(i);
        }
        
        return list;
        
    }
    
    private List<Long> fact(long n)
    {
     TreeSet<Long> factors = new TreeSet<Long>();
     
     factors.add(n);
     factors.add(1L);
     
     for(long i = n - 1; i >= Math.sqrt(n); i--)
	      if(n % i == 0)
	      {
	       factors.add(i);
	       factors.add(n / i);
	      }
     
     return factors.stream().collect(Collectors.toList());
    }
    
    private String minFact(long n) {
    	String str = 1 + " " + n;
	     long min = Long.MAX_VALUE;
	     for(long i = n - 1; i >= Math.sqrt(n); i--)
		      if(n % i == 0) {
		    	  long x = i - n/i;
		    	  
		    	  if (x < min) {
		    		  min = x;
		    		  str = n/i + " " + i;
		    	  }
		       
		      }
	     
	     return str;
    }
    
    private long gcd (long a, long b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
         
        return b1.gcd(b2).longValue();
    }
    
    private long lcm (long a, long b, long gcd) {
    	return a * b / gcd;
    }
        
    private boolean isPowerOfTwo(long x) {
        return (x != 0) && ((x & (x - 1)) == 0);
    }
    
    private int exponentOfTwo(long n) {
    	return (int)( Math.floor(Math.log(n) / Math.log(2)));

    }

    private Long sumDiagLR (Long[][] array) {
        long sum = 0;
        int i = 0, j = 0;

        while (i < array.length && j < array.length) {
            sum += array[i][j];
            i++;
            j++;
        }

        return sum;
    }

    private Long sumDiagRL (Long[][] array) {
       long sum = 0;
       int i = array.length-1, j = 0;

       while (i >=0 && j < array.length) {
           sum += array[i][j];
           i--;
           j++;
       }

       return sum;
   }


    private BigInteger factorial( String n )
    {
        BigInteger k = new BigInteger( n );
        BigInteger ans = BigInteger.ONE;

        while ( k.compareTo( BigInteger.ONE ) > 0 )
        {
            ans = ans.multiply( k );
            k = k.subtract( BigInteger.ONE );
        }

        return ans;
    }

    private long combinations( long n, long r )
    {
        return ( factorial( String.valueOf( n ) ).divide( ( new BigInteger( String.valueOf( r ) ).multiply( factorial( String.valueOf( n - r ) ) ) ) ) ).longValue();
    }


    private String binaryXOR( String s1, String s2 )
    {
        BigInteger a = new BigInteger( s1, 2 );
        BigInteger b = new BigInteger( s2, 2 );

        return a.xor( b ).toString( 2 );

    }


    private static void findDP( Node node )
    {
        for ( Node child : node.children )
        {
            if ( child.value > node.value )
            {
                child.dp = Math.max( child.dp, node.dp + 1 );
                //findDP( child );
            }
        }
    }

    private static class Obj implements Comparable<Obj>
    {
        String name;
        int value;

        public Obj( int value )
        {
            this.value = value;
        }

        public Obj( String name, int value )
        {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo( Obj o )
        {
            return o.value - this.value;
        }
    }


    private static class Edge
    {
        PNode src;
        PNode des;
        long cost;

        public Edge (PNode src, PNode des, long cost) {
            this.src = src;
            this.des = des;
            this.cost = cost;
        }
    }

    private static class PNode
    {
        List<Edge> edges;
        long value;
        boolean isTrue;

        public PNode() {
            this.edges = new ArrayList<>(  );
            this.isTrue = false;
        }

        public PNode(long value ) {
           this.edges = new ArrayList<>(  );
           this.isTrue = false;
            this.value = value;
       }
    }

    private static class Node
    {
        long value;
        long dp;
        List<Node> children;
        Node parent;

        public  Node(){};

        public Node( int value )
        {
            this.value = value;
            dp = 1;
            children = new ArrayList<Node>();
        }
    }

    private static boolean isInt( String s )
    {
        if ( s.length() < 1 )
            return false;
        else
        {
            for ( char c : s.toCharArray() )
            {
                if ( c < '0' || c > '9' )
                {
                    return false;
                }
            }
        }

        return true;
    }

    private static Map<String, Integer> findSubString( String s, int k )
    {
        Map<String, Integer> map = new HashMap<>();
        for ( int i = 0; i < s.length() - ( k - 1 ); i++ )
        {
            String str = new String( s.substring( i, i + k ) );
            if ( map.containsKey( str ) )
            {
                map.put( str, map.get( str ) + 1 );
            }
            else
            {
                map.put( str, 1 );

            }
        }

        return map;
    }


    //mergesort

    public static Comparable[] mergeSort( Comparable[] list )
    {
        if ( list.length <= 1 )
        {
            return list;
        }

        Comparable[] left = new Comparable[ list.length / 2 ];
        Comparable[] right = new Comparable[ list.length - left.length ];
        System.arraycopy( list, 0, left, 0, left.length );
        System.arraycopy( list, left.length, right, 0, right.length );

        mergeSort( left );
        mergeSort( right );

        merge( left, right, list );
        return list;
    }

    private static void merge( Comparable[] left, Comparable[] right, Comparable[] result )
    {
        int leftIdx = 0;
        int rightIdx = 0;
        int index = 0;

        while ( leftIdx < left.length && rightIdx < right.length )
        {
            if ( left[ leftIdx ].compareTo( right[ rightIdx ] ) < 0 )
            {
                result[ index++ ] = left[ leftIdx ];
                leftIdx++;
            }
            else
            {
                result[ index++ ] = right[ rightIdx ];
                rightIdx++;
            }
        }

        System.arraycopy( left, leftIdx, result, index, left.length - leftIdx );
        System.arraycopy( right, rightIdx, result, index, right.length - rightIdx );
    }

    public static List<Obj> mergeSort( List<Obj> list )
    {
        if ( list.size() <= 1 )
        {
            return list;
        }

        List<Obj> left = new ArrayList( list.subList( 0, list.size() / 2 ) );
        List<Obj> right = new ArrayList( list.subList( left.size(), list.size() ) );

        left = mergeSort( left );
        right = mergeSort( right );

        list = merge( left, right );

        return list;
    }

    private static List<Obj> merge( List<Obj> left, List<Obj> right )
    {
        int leftCounter = 0, rightCounter = 0;
        List<Obj> result = new ArrayList<>();

        while ( leftCounter < left.size() && rightCounter < right.size() )
        {
            Obj leftItem = left.get( leftCounter );
            Obj rightItem = right.get( rightCounter );

            if ( leftItem.compareTo( rightItem ) < 0 )
            {
                result.add( leftItem );
                leftCounter++;
            }
            else
            {
                result.add( rightItem );
                rightCounter++;
            }
        }

        if ( leftCounter >= left.size() )
            result.addAll( right.subList( rightCounter, right.size() ) );
        else if ( rightCounter >= right.size() )
            result.addAll( left.subList( leftCounter, left.size() ) );

        return result;
    }

    public static void main( String[] args )
    {
        new Solution().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run()
    {
        try
        {
            reader = new BufferedReader( new InputStreamReader( System.in ) );
            tokenizer = null;
            writer = new PrintWriter( System.out );
            solve();
            reader.close();
            writer.close();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            System.exit( 1 );
        }
    }

    int nextInt() throws IOException
    {
        return Integer.parseInt( nextToken() );
    }

    long nextLong() throws IOException
    {
        return Long.parseLong( nextToken() );
    }

    double nextDouble() throws IOException
    {
        return Double.parseDouble( nextToken() );
    }

    String nextToken() throws IOException
    {
        while ( tokenizer == null || !tokenizer.hasMoreTokens() )
        {
            tokenizer = new StringTokenizer( reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    
    public class Tuple {
    	Object fst;
    	Object snd;
    	
    	public Tuple(Object fst, Object snd) {
    		this.fst = fst;
    		this.snd = snd;
    	}
    	
    	public Object getFst() {
    		return fst;
    	}
    	
    	public Object getSnd() {
    		return snd;
    	}
    	
    }

    // Arrays.sort(array, Comparator.comparing((int[] arr) -> arr[1]));
}