import java.io.*;
public class PD_e87 {
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        //String str;
        //int p1,p2,p3,min_l;
        int s;
        double len,len1;
        for(int i=0;i<t;i++){
            s=Integer.parseInt(in.readLine());
            s=s*2;
            len=1/(Math.sin(Math.PI/s));
            System.out.println(len*Math.cos(Math.PI/(2*s)));
        }
    }
}