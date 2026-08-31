import java.util.*;
import java.io.*;
public class code{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        char[] a = new char[30];
        char[] b = new char[30];
        Arrays.fill(a,'0');
        Arrays.fill(b,'0');
        int ok,ok2;
        String sa = new String(a);
        //out.println(sa);
        //out.flush();
        String sb = new String(b);
        int va,vb;
        va = Integer.parseInt(sa,2);
        vb = Integer.parseInt(sb,2);
        out.println("? "+va+" "+vb);
        out.flush();
        ok = sc.nextInt();
        for(int i=0;i<30;i++){
            if(ok==0){
                b[i] = '0';
                a[i] = '1';
                sa = new String(a);
                sb = new String(b);
                va = Integer.parseInt(sa,2);
                vb = Integer.parseInt(sb,2);
                out.println("? "+va+" "+vb);
                out.flush();
                ok2 = sc.nextInt();
                if(ok2==1){
                    a[i] = '0';
                }else{
                    b[i] = '1';
                }
            }else{
                a[i] = '1';
                b[i] = '1';
                sa = new String(a);
                sb = new String(b);
                va = Integer.parseInt(sa,2);
                vb = Integer.parseInt(sb,2);
                out.println("? "+va+" "+vb);
                out.flush();
                ok2 = sc.nextInt();
                if(ok==ok2){
                    b[i] = '0';
                    sa = new String(a);
                    sb = new String(b);
                    va = Integer.parseInt(sa,2);
                    vb = Integer.parseInt(sb,2);
                    out.println("? "+va+" "+vb);
                    out.flush();
                    ok2 = sc.nextInt();
                    if(ok2==1){
                        a[i] = '0';
                    }else{
                        b[i] = '1';
                    }
                }else{
                    if(ok==1){
                        b[i] = '0';
                        sa = new String(a);
                        sb = new String(b);
                        va = Integer.parseInt(sa,2);
                        vb = Integer.parseInt(sb,2);
                        out.println("? "+va+" "+vb);
                        out.flush();
                        ok = sc.nextInt();
                    }
                    else {
                        a[i] = '0';
                        sa = new String(a);
                        sb = new String(b);
                        va = Integer.parseInt(sa,2);
                        vb = Integer.parseInt(sb,2);
                        out.println("? "+va+" "+vb);
                        out.flush();
                        ok = sc.nextInt();
                    }
                }
            }
        }
        sa = new String(a);
        sb = new String(b);
        va = Integer.parseInt(sa,2);
        vb = Integer.parseInt(sb,2);
        out.println("! "+va+" "+vb);
        out.flush();
    }
}