import java.io.*;
import java.util.*;
public class HelpfulMaths {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> list = new ArrayList<Integer>();
        
        for(char c: str.toCharArray()){
            if(c != '+'){
                int num = Character.getNumericValue(c);
                list.add(num);
            }
        }
        
        Collections.sort(list);
        String ans = "";
        for(int i = 0; i<list.size();i++){
            ans = ans + ("+" + list.get(i));
        }
        System.out.println(ans.substring(1, ans.length()));
    }
}
