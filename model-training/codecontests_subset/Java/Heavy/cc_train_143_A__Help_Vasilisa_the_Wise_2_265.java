
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A
{
    BufferedReader m_in;
    PrintWriter m_out;
    StringTokenizer m_st;
    
    public static void main(String[] args)
    {
        try
        {
            new A().run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    String nt() throws Exception
    {
        while (m_st==null||!m_st.hasMoreTokens())
        {
            m_st = new StringTokenizer(m_in.readLine());
        }
        return m_st.nextToken();
    }
    
    String nl() throws Exception
    {
        m_st = null;
        return m_in.readLine();
    }
    
    int ni() throws Exception
    {
        return Integer.parseInt(nt());
    }
    
    double nd() throws Exception
    {
        return Double.parseDouble(nt());
    }
    
    void add(String s)
    {
        m_out.print(s);
    }
    
    void addln(String s)
    {
        m_out.println(s);
    }
    
    void prc(String s)
    {
        System.out.print(s);
    }
    
    void prcln(String s)
    {
        System.out.println(s);
    }
    
    public void run() throws Exception
    {
//        m_in = new BufferedReader(new FileReader("input.txt"));
//        m_out = new PrintWriter(new FileWriter("output.txt"));
        m_in = new BufferedReader(new InputStreamReader(System.in));
        m_out = new PrintWriter(System.out);      

        //
        int r1 = ni();
        int r2 = ni();
        int c1 = ni();
        int c2 = ni();
        int d1 = ni();
        int d2 = ni();
        
        boolean ok = false;
        boolean used[] = new boolean[10];
        l1:for (int x1 = 1; x1 <= 9; x1++)
        {
            used[x1] = true;
            for (int x2 = 1; x2 <= 9; x2++)
            {
                if (used[x2])
                {
                    continue;
                }
                used[x2] = true;
                for (int x3 = 1; x3 <= 9; x3++)
                {
                    if (used[x3])
                    {
                        continue;
                    }
                    used[x3] = true;
                    for (int x4 = 1; x4 <= 9; x4++)
                    {
                        if (used[x4])
                        {
                            continue;
                        }
                        
                        if (x1 + x2==r1
                                && x3 + x4 == r2
                                && x1+x3 == c1
                                && x2+x4 == c2
                                && x1+x4 == d1
                                && x2+x3 == d2)
                        {
                            prcln(x1 + " " + x2 + "\n" + x3 + " " + x4);
                            ok = true;
                            break l1;
                        }
                    }
                    used[x3] = false;
                }
                used[x2] = false;
            }
            used[x1] = false;
        }
        
        if (!ok)
        {
            prcln("-1");
        }
        
        //
        m_in.close();
        m_out.flush();
        m_out.close();
    }
}
