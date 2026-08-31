import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main{
    public static String res(String s ,int x){
        if (x==1)
            return s;
        if ((s.length()+1)%x==0)
            return "-1";
        char [] temp = new char [s.length()+1];
        for (int i=0; i<s.length();i++)
            temp[i]=s.charAt(i);
        temp[s.length()]='|';
        Arrays.sort(temp);
        String ans="";
        for (int i=0;i<s.length();i++){
            if (temp[i]!=temp[i+1]&&(i+1)%x!=0)
                return "-1";
            else if ((i+1)%x==0)
                ans+=temp[i]+"";        
        }
        String answer="";
        while(x-->0)
            answer+=ans;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        String s =br.readLine();
        System.out.println(res(s,x));
    }

}
