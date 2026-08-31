import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mbt
 */
public class A {

    public static void main(String[] args) throws IOException {
        new Solver().solve();
    }
}

class Solver{
    
    void solve() throws IOException{
        Scanner reader= new Scanner(System.in);
        int n= reader.nextInt();
        int count100=0, count200=0;
        for(int i=0; i<n; i++)
            if (reader.nextInt()==100)
                count100++;
            else    
                count200++;
        
        int halfSum= count100*100 + count200*200;
        halfSum /= 2;
        
        if (halfSum%100!=0)
            System.out.println("NO");
        else{
            int sum=0;
            while(count200>0){
                if (sum+200<=halfSum){
                    sum += 200;
                    count200--;
                }else
                    break;
            }
            if (sum==halfSum)
                System.out.println("YES");
            else{
                int diff= halfSum-sum;
                if (count100 > diff/100)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
}