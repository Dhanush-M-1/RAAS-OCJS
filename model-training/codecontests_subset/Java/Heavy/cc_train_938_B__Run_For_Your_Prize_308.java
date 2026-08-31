import java.util.*;

public class B{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int a[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        int myPosition = 1;
        int friendPosition = 1000000;
        
        int i=0;
        int j = n-1;
        int minSeconds =0;
        
        while(i <= j)
        {
            int myTime = a[i] - myPosition;
            int friendTime = friendPosition - a[j];
            if(myTime <= friendTime)
            {
                i++;
                minSeconds = myTime;
            }
            else
            {
                j--;
                minSeconds = friendTime;
            }
        }
        
        
        System.out.println(minSeconds);

        in.close();
    }   
}