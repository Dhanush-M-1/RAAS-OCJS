import java.io.*;
import java.util.StringTokenizer;
public class A168 {
    public static void main(String[] args) throws IOException {
        BufferedReader data=new BufferedReader(new InputStreamReader(System.in));
        String s=data.readLine();
        StringTokenizer st=new StringTokenizer(s);
        String key=st.nextToken();
        int n=Integer.parseInt(key);
        key=st.nextToken();
        int x=Integer.parseInt(key);
        key=st.nextToken();
        int y=Integer.parseInt(key);
        double z=(double)(n*y)/100;
        z=Math.ceil(z);
        int ans=(int) (z-x);
        if(z<=x) System.out.println("0");
        else System.out.println(ans);
    }
}
