import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        long ANS=0L;
        for(int i=0;i<N;i++){
            ANS+=sc.nextLong()-1L;
        }
        System.out.println(ANS);
    }
}
