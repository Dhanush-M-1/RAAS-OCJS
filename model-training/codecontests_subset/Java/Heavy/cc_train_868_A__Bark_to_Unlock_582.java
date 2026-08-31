
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//abdxy
public class Mymain {

    public static void main(String[] args) throws IOException {
      BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      String p=in.readLine();
      int n=Integer.parseInt(in.readLine());
      boolean f1=false,f2=false,f3=false;
        while(n-->0)
        {
            String s=in.readLine();
            if(s.equals(p))f3=true;
            if(s.charAt(0)==p.charAt(1))f1=true;
            if(s.charAt(1)==p.charAt(0))f2=true;
        }
        if(f3||(f2&&f1))System.out.println("YES");
        else System.out.println("NO");

      
    }
    
}