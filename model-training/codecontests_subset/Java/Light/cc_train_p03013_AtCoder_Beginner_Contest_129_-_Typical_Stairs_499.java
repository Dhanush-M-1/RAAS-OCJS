import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
      	int CONST_MOD = (int) (Math.pow(10, 9) + 7);
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> dp = new ArrayList<Integer>();
      
      	for(int i=0; i<n+1; i++)
        {
          dp.add(1);
        }
        
        for(int i = 0; i < m; i++)
        {
            dp.set(sc.nextInt(), 0);
        }
        
        for(int i = 2; i < n+1; i++)
        {
            if( dp.get(i) != 0 )
            { 
            	dp.set(i, (dp.get(i-1) + dp.get(i-2))%CONST_MOD);
            }
        }
        
        System.out.println(dp.get(n));
    }
}