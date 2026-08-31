
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int numberOfTestCases = sc.nextInt();
        int ar[] = new int[1001],sizeA=0,sizeB=0,a,answer;
        for (int i = 0; i < numberOfTestCases; i++) {
            sizeA = sc.nextInt();
            sizeB = sc.nextInt();
            answer = -1;
            Arrays.fill(ar, 0);
            for (int j = 0; j < sizeA; j++) {
                a=sc.nextInt();
                ar[a] = 1;
            }
            for (int j = 0; j < sizeB; j++) {
                a = sc.nextInt();
                if(answer==-1) answer=ar[a]==1?a:-1;

            }
            if (answer!=-1){
                System.out.println("YES");
                System.out.println("1 "+answer);
            }
            else{
                System.out.println("NO");
            }

        }
    }

}
