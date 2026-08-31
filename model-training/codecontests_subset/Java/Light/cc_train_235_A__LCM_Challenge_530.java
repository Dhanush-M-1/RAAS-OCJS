import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LCMChallenge {

    public static long find(int n){
        long fOdd=1,sOdd=1;
        long lcmVal=1;
        for(long i=n;i>0 && (fOdd==1 || sOdd==1) ;i--){
            if(i%2!=0){
                if(fOdd==1)
                    fOdd=i;
                else
                    sOdd=i;
            }
        }
        for(long i=n,count=0;i>0 && count<2;i--){
            if(i%2==0){
                long tempVal=(fOdd*sOdd*i)/gcd(fOdd*sOdd,i);
                if(tempVal>lcmVal)
                    lcmVal=tempVal;
                count++;
            }
        }
        
        return lcmVal;
    }
    
    public static long gcd(long x, long y) {
        
        if (x == 0) {
            return y;
        }
        
      while (y != 0) {
        if (x > y) {
            x = x - y;
        }
        else {
            y = y - x;
        }
      }
      return x;
    }
    
    public static void main(String arg[]){
        InputStreamReader inp = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inp);
        try{
            String val=br.readLine();
            Integer n=Integer.parseInt(val);
            System.out.println(find(n));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
