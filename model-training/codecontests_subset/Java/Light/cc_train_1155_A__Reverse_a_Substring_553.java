
import java.util.*; import java.io.*;

public class lemmino {

    static Scanner scan = new Scanner(System.in);
    static int MAX = 111111;
    public static void main(String[] args) throws IOException {

        int N = scan.nextInt(); char[] arr = scan.next().toCharArray();
        int maxTi = 0; boolean flag = false;
        for(int i=1; i<N; i++){
            if(arr[i] > arr[maxTi]){maxTi = i;}
            else if(arr[i] < arr[maxTi]){System.out.println("YES\n"+(maxTi+1)+" "+(i+1)); flag = true; break;}
        }
        if(!flag){
            System.out.println("NO");
        }
    }

}
