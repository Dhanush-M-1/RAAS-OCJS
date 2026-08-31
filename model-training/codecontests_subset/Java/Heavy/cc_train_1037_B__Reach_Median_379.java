import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Program__B {
    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //List<Long> arr = asList(1L);
        //Long m = 2L;
        Long m = readLongsList().get(1);
        List<Long> arr = readLongsList();

        arr.sort(Long::compare);

        int pos = arr.size() / 2;
        if (arr.get(pos).equals(m)) {
            System.out.println(0);
            return;
        }
        long cnt = Math.abs(arr.get(pos) - m);
        for (int i = pos - 1; i >= 0; i--) {
            if (arr.get(i) > m) {
                cnt += arr.get(i) - m;
            }
        }
        for (int i = pos + 1; i < arr.size(); i++) {
            if (arr.get(i) < m) {
                cnt += m - arr.get(i);
            }
        }
        System.out.println(cnt);



//        int first = arr.indexOf(m);
//        int last = arr.lastIndexOf(m);
//        int pos = arr.size() / 2;
//        if (first <= pos && pos <= last) {
//            System.out.println(0);
//            return;
//        }
//        if (pos > last) {
//            arr = arr.stream().map(x -> -x).collect(Collectors.toList());
//            arr.sort(Long::compare);
//            m = -m;
//            first = arr.indexOf(m);
//            last = arr.lastIndexOf(m);
//        }
//        // pos < first now
//        int cnt = 0;
//        int shiftRemaining = first - pos;
//        int i = first - 1;
//        while (shiftRemaining > 0) {
//            Long c = arr.get(i);
//            if (c < m) {
//                cnt++;
//                arr.set(i, c + 1);
//                if (arr.get(i).equals(m)) {
//                    shiftRemaining--;
//                    i--;
//                }
//            }
//        }
//        System.out.println(cnt);
    }

    private static List<Long> readLongsList() throws IOException {
        return Stream.of(buffer.readLine().split(" ")).map(Long::parseLong).collect(toList());
    }
}
