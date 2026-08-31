import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Elections {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.valueOf(br.readLine());
        String[] s = br.readLine().split(" ");

        int max = 0;
        int elodreip = 0;
        for(int i = 0; i < s.length; i++){
            if(max < Integer.valueOf(s[i])){
                max = Integer.valueOf(s[i]);
            }
            elodreip += Integer.valueOf(s[i]);
        }
        int k = max;
        int awurk = 0;
        boolean enough = true;
        while(enough){
            awurk = 0;
            for(int i = 0; i < s.length; i++){
                awurk += (k - Integer.valueOf(s[i]));
            }
            if(awurk > elodreip){
                enough = false;
            } else k++;
        }
        System.out.println(k);
    }
}
