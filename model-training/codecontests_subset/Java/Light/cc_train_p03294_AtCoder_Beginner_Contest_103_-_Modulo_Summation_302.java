
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int[] a=new int[N];
        long result=0;
        for(int i=0;i<N;i++){
            result+=scanner.nextInt()-1;
        }
        System.out.println(result);
    }
}
