import java.util.*;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String arg[]) {
        // 読み取り
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            list.add(Integer.parseInt(sc.next()));
        }
        int index1 = IntStream.range(0, n).filter(i -> list.get(i) <= 500000).max().orElse(-1);
        int index2 = index1 + 1;
        int time1 = (index1 != -1 ? list.get(index1) - 1 : 0);
        int time2 = (index2 < n ? 1000000 - list.get(index2) : 0);
        System.out.println(Math.max(time1, time2));
    }
}
