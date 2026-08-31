import java.io.PrintWriter;
import java.util.Scanner;


public class A {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();
        
        int count=0;
        
        if((n*y)%100==0)
            count=(n*y)/100;
        else
            count=(n*y)/100 + 1;
        PrintWriter out=new PrintWriter(System.out);
        
        if(count<=x)
            out.print('0');
        else{
            count-=x;
            out.print(count);
        }
        
        out.flush();
    }

}
