import java.util.Scanner;

/**
 *
 * @author Hartha
 */
public class KitaharaHarukiSGift {

    static int nVal;
    static int[] apples;
    static int mom[][][] = new int[101][201][201];
    public static boolean isPos(int i, int ch1, int ch2)
    {
        if(i == nVal)
            return ch1 == ch2;
        if(mom[i][ch1][ch2] != 0)
        {
            if(mom[i][ch1][ch2] == 1) return true;
            return false;
        }
        
        if(isPos(i+1, ch1+apples[i], ch2)){
            mom[i][ch1][ch2] = 1;
            return true;
        }
        else
            mom[i][ch1][ch2] = 2;
        
        if(isPos(i+1, ch1, ch2 + +apples[i])){
            mom[i][ch1][ch2] = 1;
            return true;
        }
        else
         mom[i][ch1][ch2] = 2;
        
        return false;
        
    }
    
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        nVal = sin.nextInt();
        apples = new int[nVal];
        for(int i = 0; i < nVal; i++)
        {
            int t = sin.nextInt();
            if(t == 200)
                apples[i] = 2;
            else
                apples [i]= 1;
        }
        if(isPos(0,0,0))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
