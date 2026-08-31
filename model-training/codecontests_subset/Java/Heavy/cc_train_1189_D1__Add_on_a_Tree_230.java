//Author: Patel Rag
//Java version "1.8.0_211"
import java.util.*;
import java.io.*;

public class Main
{
  static Reader fr;
  static Print log;
  static class Reader
  {
    private byte[] buffer = new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Reader()
    {
        in = System.in;
    }
    public Reader(InputStream in)
    {
      this.in = in;
    }
    private int scan() throws IOException
    {
        if(index >= total)
        {
            index = 0;
            total = in.read(buffer);
            if(total <= 0)
            {
              return -1;
            }
        }
        return buffer[index++];
    }
    public final int nextInt() throws IOException
    {
      return (int)nextLong();
    }
    public final long nextLong() throws IOException
    {
        long res = 0;
        int n = scan();
        while(isWhiteSpace(n))
        {
          n = scan();
        }
        int neg = 1;
        if(n == '-')
        {
            neg = -1;
            n = scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n >= '0' && n <= '9')
            {
                res *= 10;
                res += (n - '0');
                n = scan();
            }
            else
            {
              throw new InputMismatchException();
            }
        }
        return neg*res;
    }
    public final double nextDouble() throws IOException
    {
        double doub = 0;
        int n = scan();
        while(isWhiteSpace(n))
        {
          n=scan();
        }
        int neg = 1;
        if(n == '-')
        {
            neg = -1;
            n = scan();
        }
        while(!isWhiteSpace(n) && n != '.')
        {
            if(n >= '0' && n <= '9')
            {
                doub *= 10;
                doub += n-'0';
                n = scan();
            }
            else
            {
              throw new InputMismatchException();
            }
        }
        if(n == '.')
        {
            n = scan();
            double temp = 1;
            while(!isWhiteSpace(n))
            {
                if(n >= '0' && n <= '9')
                {
                    temp/=10;
                    doub += (n-'0')*temp;
                    n = scan();
                }
                else
                {
                  throw new InputMismatchException();
                }
            }
        }
        return neg*doub;
    }
    public final String next() throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int n = scan();
        while(isWhiteSpace(n))
        {
          n = scan();
        }
        while(!isWhiteSpace(n))
        {
            sb.append((char)n);
            n = scan();
        }
        return sb.toString();
    }
    public final String nextLine() throws IOException
    {
      StringBuilder sb = new StringBuilder();
      int n = scan();
      while(isWhiteSpace(n))
      {
        n = scan();
      }
      while(n != '\n' && n != '\r' && n != -1)
      {
        sb.append((char)n);
        n = scan();
      }
      return sb.toString();
    }
    private boolean isWhiteSpace(int n)
    {
        if(n == ' ' || n == '\n'|| n == '\r' || n == '\t'|| n == -1)
        return true;
        return false;
    }
  }
  static class FastReader
  {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next()
    {
      while (st == null || !st.hasMoreElements())
      {
        try
        {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException  e)
        {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt()
    {
      return Integer.parseInt(next());
    }

    long nextLong()
    {
      return Long.parseLong(next());
    }

    double nextDouble()
    {
      return Double.parseDouble(next());
    }

    String nextLine()
    {
      String str = "";
      try
      {
        str = br.readLine();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      return str;
    }
    void close() throws IOException
    {
      br.close();
    }
  }
  static class Print
  {
      private final BufferedWriter bw;
      public Print()
      {
          this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
      }
      public void print(Object object)throws IOException
      {
          bw.append(""+object);
      }
      public void println(Object object)throws IOException
      {
          print(object);
          bw.append("\n");
      }
      public void close()throws IOException
      {
          bw.close();
      }
  }
  static long modExp(long x, long n, long mod)    //Modular exponentiation
  {
    long result = 1;
    while(n > 0)
    {
        if(n % 2 == 1)
            result = (result%mod * x%mod)%mod;
        x = (x%mod * x%mod)%mod;
        n=n/2;
    }
    return result;
  }
  static long gcd(long a, long b)
  {
    if(a==0) return b;
    return gcd(b%a,a);
  }
  static class TrieNode
  {
    TrieNode[] children;
    boolean isLeaf;
    ArrayList<String> word;
    public TrieNode()
    {
      children = new TrieNode[26];
      for(int i = 0; i < 26; i++) children[i] = null;
      isLeaf = false;
      word = new ArrayList<>();
    }
  }
  static TrieNode root;
  static void insert(String word)
  {
    TrieNode pCrawl = root;
    for(int lev = 0; lev < word.length(); lev++)
    {
      if(word.charAt(lev) < 'A' || word.charAt(lev) > 'Z') continue;

      int alphabet = word.charAt(lev) - 'A';
      if(pCrawl.children[alphabet] == null)
      {
        pCrawl.children[alphabet] = new TrieNode();
      }
      pCrawl = pCrawl.children[alphabet];
    }
    pCrawl.isLeaf = true;
    (pCrawl.word).add(word);
  }
  static void printAll(TrieNode root) throws IOException
  {
    if(root.isLeaf)
    {
      for(String str : root.word)
      {
        log.print(str + " ");
      }
    }
    for(int i = 0; i < 26; i++)
    {
      if(root.children[i] != null)
      printAll(root.children[i]);
    }
  }
  static boolean search(String pattern) throws IOException
  {
    int index;
    TrieNode pCrawl = root;
    for(int i = 0; i < pattern.length(); i++)
    {
      index  = pattern.charAt(i) - 'A';
      if(pCrawl.children[index] == null)
      return false;
      pCrawl = pCrawl.children[index];
    }
    printAll(pCrawl);
    return true;
  }
  public static void main(String[] args)
  throws IOException
  {
    fr = new Reader();
    log = new Print();
    int n = fr.nextInt();
    int[] deg = new int[n];
    for(int i = 0; i < n-1; i++)
    {
      int u = fr.nextInt() - 1;
      int v = fr.nextInt() - 1;
      deg[u]++;
      deg[v]++;
    }
    for(int i = 0; i < n; i++)
    {
      if(deg[i] == 2)
      {
        log.println("NO");
        log.close();
        return;
      }
    }
    log.println("YES");
    log.close();
  }
}
class Pair<U, V>  // Pair class
{
    public final U first;       // first field of a Pair
    public final V second;      // second field of a Pair

    private Pair(U first, V second)
    {
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o)
    {
      if (this == o) return true;

      if (o == null || getClass() != o.getClass()) return false;

      Pair<?, ?> pair = (Pair<?, ?>) o;

      if (!first.equals(pair.first)) return false;
      return second.equals(pair.second);
    }

    @Override
    public int hashCode()
    {
      return 31 * first.hashCode() + second.hashCode();
    }

    public static <U, V> Pair <U, V> of(U a, V b)
    {
      return new Pair<>(a, b);
    }
}
class myComp implements Comparator<Pair>
{
  public int compare(Pair a,Pair b)
  {
    if((Integer)a.second <= (Integer)b.second) return 1;
    return -1;
  }
}
class BIT       //Binary Indexed Tree
{
  public long[] m_array;

  public BIT(long[] dat)
  {
    m_array = new long[dat.length + 1];
    Arrays.fill(m_array,0);
    for(int i = 0; i < dat.length; i++)
    {
      m_array[i + 1] = dat[i];
    }
    for(int i = 1; i < m_array.length; i++)
    {
      int j = i + (i & -i);
      if(j < m_array.length)
      {
        m_array[j] = m_array[j] + m_array[i];
      }
    }
  }

  public final long prefix_query(int i)
  {
    long result = 0;
    for(++i; i > 0; i = i - (i & -i))
    {
      result = result + m_array[i];
    }
    return result;
  }

  public final long range_query(int fro, int to)
  {
    if(fro == 0)
    {
      return prefix_query(to);
    }
    else
    {
      return (prefix_query(to) - prefix_query(fro - 1));
    }
  }

  public void update(int i, long add)
  {
    for(++i; i < m_array.length; i = i + (i & -i))
    {
      m_array[i] = m_array[i] + add;
    }
  }
}
