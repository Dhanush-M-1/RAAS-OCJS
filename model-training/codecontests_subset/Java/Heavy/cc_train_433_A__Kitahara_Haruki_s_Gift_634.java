import java.io.*;

public class FairDivison {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            String[] x = br.readLine().split(" ");

            int[] a = new int[n];

            for(int i=0 ; i<n ; i++)
                a[i] = Integer.parseInt(x[i])/100;

            System.out.println(solve(n,a) ? "YES" : "NO");
    }    

    static boolean solve(int n , int[] a){

        int sum = 0;
        int oddCnt = 0;
        int evenCnt = 0;

        for(int i=0 ; i<n ; i++){

            sum += a[i];

            if((a[i]&1) == 0)
                evenCnt++;

            else
                oddCnt++;
        }

        if((sum&1) != 0)
            return false;

        if((n&1) == 0){
            return true;
        }

        else{

            if(oddCnt == 0)
                return false;
                
            if((evenCnt&1) == 0)
                return false;

            return true;
        }
    }
}
