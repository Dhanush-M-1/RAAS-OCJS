import java.io.*;
import java.util.*;

public class Main implements Runnable
{
    void solve() throws IOException
    {
    	int r1 = sc.nextInt();
    	int r2 = sc.nextInt();
    	int c1 = sc.nextInt();
    	int c2 = sc.nextInt();
    	int d1 = sc.nextInt();
    	int d2 = sc.nextInt();
    	int a1 = r1+c1-d2;
    	int a2 = r1+d2-c1;
    	int a3 = c1+d2-r1;
    	int a4 = 2*r2+r1-c1-d2;
    	if(a1>0&&a2>0&&a3>0&&a4>0&&a1<=18&&a2<=18&&a3<=18&&a4<=18&&a1%2==0&&a2%2==0&&a3%2==0&&a4%2==0&&a1!=a2&&a1!=a3&&a1!=a4&&a2!=a3&&a2!=a4&&a3!=a4)
    	{
    		a1/=2;a2/=2;a3/=2;a4/=2;
    		if(a1+a2==r1&&a1+a3==c1&&a1+a4==d1&&a3+a4==r2&&a4+a2==c2&&a3+a2==d2)
    		{
	    		ps.println(a1+" "+a2);
	    		ps.println(a3+" "+a4);
	    	}
    		else
        		ps.println(-1);
    	}
    	else
    		ps.println(-1);
    }

    Scanner sc;
    PrintStream ps;
       
    public void run()
    {
        try
        {
	        sc = new Scanner(System.in);
	        //sc = new Scanner(new File("a.in"));
	        ps = new PrintStream(System.out);
	        solve();
	        sc.close();
	        ps.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
   
    public static void main(String[] args)
    {
           new Thread(new Main()).start();
    }    
}