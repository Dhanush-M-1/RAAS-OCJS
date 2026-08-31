import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class BCF432A {
    public static void main(String[]args)throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a1=Integer.parseInt(st.nextToken());
        long a2=Integer.parseInt(st.nextToken());
        long b1=Integer.parseInt(st.nextToken());
        long b2=Integer.parseInt(st.nextToken());
        long c1=Integer.parseInt(st.nextToken());
        long c2=Integer.parseInt(st.nextToken());
        long dab=dist(a1,a2,b1,b2);
        long dac=dist(a1,a2,c1,c2);
        long dbc=dist(b1,b2,c1,c2);
        if((b2-a2)*(c1-b1)==(c2-b2)*(b1-a1))
            System.out.println("No");
        else if(dab!=dbc)
            System.out.println("No");
        else
            System.out.println("Yes");
        
    }
    static Long dist(long a,long b,long c,long d)
    {
        long dd=((a-c)*(a-c))+((b-d)*(b-d));
        return dd;
    }
}
