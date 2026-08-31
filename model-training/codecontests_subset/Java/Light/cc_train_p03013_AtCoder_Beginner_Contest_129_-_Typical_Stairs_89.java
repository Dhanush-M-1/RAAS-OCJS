import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<Integer> holeList  = new HashSet<>();

        for (int i = 0; i < m; i++){
            holeList.add(sc.nextInt());
        }

        long count = 0;
        long countOneBefore = 1;
        long countTwoBefore = 0;

        for (int i = 0 ; i < n; i++){
            if (holeList.contains(i + 1)){
                // 穴が開いている場合
                count = 0;
                countTwoBefore = countOneBefore;
                countOneBefore = count;
            }else {
                count = countOneBefore + countTwoBefore;
                if (count >= 1000000007L){
                    count = count % 1000000007L;
                }
                countTwoBefore = countOneBefore;
                countOneBefore = count;
            }
        }

        System.out.println(count);
    }

}