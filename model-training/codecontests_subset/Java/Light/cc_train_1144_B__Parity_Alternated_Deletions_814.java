import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Codeforce1144B {
    public static void main(String[] args)throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer tokenizer = new StringTokenizer(input.readLine());
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int value;
        for (int i = 0; i < n; i++) {
            value = Integer.parseInt(tokenizer.nextToken());
            if (value % 2 == 0){
                even.add(value);
            }else{
                 odd.add(value);
            }
        }

        if (odd.size() == even.size())
            System.out.println(0);
        else{
            int length =  Math.abs(odd.size() - even.size()) - 1;
            int sum = 0;
            if (odd.size() > even.size()){
                Collections.sort(odd);
                for (int i = 0; i < length; i++) {
                    sum+= odd.get(i);
                }
            }else{
                Collections.sort(even);
                for (int i = 0; i < length; i++) {
                    sum+= even.get(i);
                }
            }
            System.out.println(sum);
        }
    }
}
