
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ABearAndRaspberry {

 
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(reader.readLine());
        int n=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        StringTokenizer st1 =new StringTokenizer(reader.readLine());
        int firstVal=Integer.parseInt(st1.nextToken());
        int maxDiff=0;
        int a=0,b=0;
        while (st1.hasMoreTokens()) {            
            int x=Integer.parseInt(st1.nextToken());
            if(firstVal-x>maxDiff)
            {
                maxDiff=firstVal-x;
                a=firstVal;
                b=x;
            }
            firstVal=x;
        }
        int total=a-b-c;
        if(maxDiff==0||total<0)
            System.out.println("0");
        else
        {
            System.out.println(total);
            
        }
    }
    
}
