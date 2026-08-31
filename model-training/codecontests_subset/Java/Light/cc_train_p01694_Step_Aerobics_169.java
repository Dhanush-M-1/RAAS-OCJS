import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public enum pattern {
        lu, //左足を踏み台に上げる
        ru, //右足を踏み台に上げる
        ld, //左足を踏み台に下げる
        rd, //右足を踏み台に下げる
        ;
    }

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine().trim()) != null && !"0".equals(line)) {
            int ans = 0;
            String[] input = line.split(" ");
            if(Stream.of(pattern.values()).map(e->e.name()).anyMatch(code->code.equals(input[0]))) {
                for(int i = 0 ; i < input.length; i++) {
                    if(i < input.length -1 && input[i].substring(1).equals("u") == input[i+1].substring(1).equals("u")) ans ++;
                    if(i < input.length -1 && input[i].substring(1).equals("d") == input[i+1].substring(1).equals("d")) ans ++;
                }
                System.out.println(ans/2);
            }
        }
    }
}

