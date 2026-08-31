import java.util.*;
import java.io.*;

public class CodeForces {

    private Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        new CodeForces().solve();
    }

    private void solve(){
        int n = in.nextInt();

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int t = in.nextInt();
            if(t % 2 == 0)
                even.add(t);
            else
                odd.add(t);
        }

        Collections.sort(odd, Collections.<Integer>reverseOrder());
        Collections.sort(even, Collections.<Integer>reverseOrder());

        int index = odd.size() < even.size() ? odd.size() + 1 : even.size() + 1;
        List<Integer> fin = odd.size() > even.size() ? odd : even;

        long res = 0;
        for(int i = index; i < fin.size(); i++){
            res += fin.get(i);
        }

        System.out.println(res);

    }

    String get(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        for(int i = 1; i < chars.length; i++){
            if(chars[i] != chars[i-1] + 1){
                return "No";
            }
        }
        return "Yes";
    }






}