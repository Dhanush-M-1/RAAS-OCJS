import java.util.*;
public class A219 {
    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
        int k = br.nextInt();
        String line = br.next();
        int[] freq = new int[26];
        for(int i = 0;i<line.length();i++){
            freq[line.charAt(i)-'a']++;
        }
        boolean good = true;
        for(int i = 0;i<26;i++){
            if(freq[i]%k != 0){
                good = false;
            }
        }
        if(!good){
            System.out.println(-1);
        }
        else{
            StringBuilder res = new StringBuilder("");
            for(int i = 0;i<26;i++){
                int times = freq[i]/k;
                for(int j = 0;j<times;j++){
                    res.append((char)(i+'a'));
                }
            }
            for(int i = 0;i<k;i++){
                System.out.print(res);
            }
            System.out.println();
        }
    }
}
