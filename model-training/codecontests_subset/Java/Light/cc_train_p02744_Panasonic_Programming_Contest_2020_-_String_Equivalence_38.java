import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        get(N).stream().forEach(System.out::println);
    }

    private static List<String> get(int N){
        if(N == 1){
            return Arrays.asList("a");
        }
        List<String> bef = get(N-1);
        return bef.stream().flatMap(Main::generate).collect(Collectors.toList());
    }

    private static Stream<String> generate(String s){
        char maxc=0;
        for(char c:s.toCharArray()){
            maxc = c<maxc ? maxc: c;
        }
        List<String> res = new ArrayList<>();
        for(char c='a';c<=maxc+1;c++){
            StringBuilder bld = new StringBuilder();
            bld.append(s);
            bld.append(c);
            res.add(bld.toString());
        }
        return res.stream();
    }

}
