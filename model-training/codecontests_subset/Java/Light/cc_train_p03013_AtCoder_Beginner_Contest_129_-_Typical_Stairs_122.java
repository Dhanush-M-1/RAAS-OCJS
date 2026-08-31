import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> List = new ArrayList<>();
        ArrayList<Long> L = new ArrayList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        L.add((long)0);
        L.add((long)1);
        int num = 0;
        for(int i=0;i<M;i++) List.add(sc.nextInt());
        List.add(0);
        for(int i=2;i<N+2;i++){
            if(List.get(num)+2!=i+1){
                long sec = (L.get(i-1)+L.get(i-2))%1000000007;
                L.add(sec);
            }
            else if(List.get(num)+2==i+1){
                long sec = 0;
                L.add(sec);
                num++;
            }
        }
        System.out.println(L.get(L.size()-1));
    }
}