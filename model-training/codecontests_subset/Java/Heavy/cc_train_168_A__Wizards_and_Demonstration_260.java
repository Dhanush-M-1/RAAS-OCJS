import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WizardsAndDemonstration {
    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
            String s=r.readLine();
            String[]sp=s.split("[ ]+");
            int n=new Integer(sp[0]),x=new Integer(sp[1]),y=new Integer(sp[2]);
            int res=0;
            while(true){
                double div=1.0*(x+res)/n;
                int d=(int)(div*100+1e-7);
                if(d>=y){
                    System.out.println(res);
                    return;
                }
                res++;
            }
    }
}
