import java.util.*;
public class Main {
    public static void main(String args []) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer>  A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        int N = sc.nextInt();
        for(int i=0;i<N;i++) A.add(sc.nextInt());
        for(int i=0;i<N;i++) B.add(sc.nextInt());
        for(int i=0;i<N-1;i++) C.add(sc.nextInt());
        int opt = 0;
        for(int i=0;i<N;i++){
            int now = A.get(i);
            opt += B.get(now-1);
            if(i!=N-1&&now==A.get(i+1)-1) opt+=C.get(now-1);
        }
        System.out.println(opt);
    }
}