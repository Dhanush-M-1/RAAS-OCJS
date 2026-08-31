import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
public class kingOfThieves {
    public static String f(String s){
    //  int max = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        int ind = -1;
        for(int i =0;i < s.length();i++){
            char c = s.charAt(i);
            if(c=='*'){
                if(flag == false){
                    ind = i;
                    flag = true;
                }
                for(int j = i+1; j < s.length();j++){
                    char  r = s.charAt(j);
                    if(r == '*'){
                        set.add(j-i);
                    }
                }
            }
        }
        if(ind != -1){
            for (Integer integer : set) {
            int count =0;
                for(int i = ind; i <s.length();i++){
                    count = 0;
                char c = s.charAt(i);
                    if(c=='*'){
                        for(int j =i+integer; j<s.length(); j+=integer){
                            char r = s.charAt(j);
                            if(r=='*'){
                                count++;
                            }else{
                                break;
                            }
                            if(count == 4){
                                return "yes";
                            }
                        }
                    }
                }
            }
        }
        return "no";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        String res = f(s);
        System.out.println(res);
    }

}
