import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForces {
    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        int r1=input.nextInt();
        int r2=input.nextInt();
        int c1=input.nextInt();
        int c2=input.nextInt();
        int d1=input.nextInt();
        int d2=input.nextInt();
        int x[]=new int[4];
        boolean check=true;
        for(int i=1;i<10;i++){
            x[0]=i;
            x[1]=r1-i;
            x[2]=c1-i;
            x[3]=d1-i;
            if(x[1]+x[3]==c2 && x[2]+x[3]==r2 && x[1]+x[2]==d2 &&
                    x[0]<10 && x[1]<10 && x[2]<10 && x[3]<10
             && x[0]>0 &&x[1]>0 && x[2]>0 && x[3]>0)
            {
                if(x[0]!=x[1] && x[0]!=x[2] && x[0]!=x[3] && x[1]!=x[2] && x[1]!=x[3] && x[2]!=x[3] ){
                    System.out.println(x[0]+" "+x[1]);
                    System.out.println(x[2]+" "+x[3]);
                    check=false;
                    break;
                }
            }
        }
        if(check)
            System.out.println(-1);

    }
}
class Reader
{
    BufferedReader br;
    StringTokenizer st;

    public Reader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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
}
