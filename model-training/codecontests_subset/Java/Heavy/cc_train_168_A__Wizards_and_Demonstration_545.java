import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main {
    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        String[] input=in.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int x=Integer.parseInt(input[1]);
        int y=Integer.parseInt(input[2]);
        int res=(int)Math.ceil(n*y/(double)100)-x;
        if(res<0) res=0;
        out.println(res);
        out.close();
    }

}