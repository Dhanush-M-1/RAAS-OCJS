import java.util.*;

public class robots{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ids = new int[n+1];
        for(int i = 1; i <= n; i++){
            ids[i] = sc.nextInt();
        }

        long whichRobot = 0;
        long currentSaid = 0;
        while(currentSaid < k){
            whichRobot++;
            currentSaid = whichRobot*(whichRobot+1)/2;
        }

        int index =(int)( (long)k - ( (whichRobot-1)*(whichRobot)/2));

        System.out.println(ids[index]);


    }
}
