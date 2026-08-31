import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        
        int yHP = input.nextInt(), yATK = input.nextInt(), yDEF = input.nextInt();
        int mHP = input.nextInt(), mATK = input.nextInt(), mDEF = input.nextInt();
        int h = input.nextInt(), a = input.nextInt(), d = input.nextInt();
        
        int ans = 1000000000;
        for(int i = 0; i <= 200; i++){
            for(int j = 0; j <= 100; j++){
                int nATK = yATK + i, nDEF = yDEF + j;
                int cost = i * a + j * d;
                if(cost >= ans) continue;
                if(nATK <= mDEF) continue;      // Yang can't win
                if(mATK <= nDEF){               // automatic win
                    ans = cost;
                    continue;
                }
                
                int nDamage = nATK - mDEF;
                int turn = (mHP + nDamage - 1) / nDamage;
                
                int mDamage = (mATK - nDEF) * turn;
                if(mDamage >= yHP){
                    cost += (mDamage - yHP + 1) * h;
                }
                if(cost < ans) ans = cost;
            }
        }
        
        System.out.println(ans);
        input.close();
    }
}
