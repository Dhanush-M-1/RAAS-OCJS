import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class HelpfulMaths {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char [] strs = line.toCharArray();
        Map<Integer,Integer> map=new TreeMap<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<line.length();i++){
            boolean b=Character.isDigit(strs[i]);
            if(b==true){
                int n=Integer.parseInt(String.valueOf(strs[i]));
                if(!map.containsKey(n)){
                    map.put(n,1);
                }
                else {
                    int count=map.get(n);
                    map.put(n,count+1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        int k=entry.getKey();
        int v= entry.getValue();
        while ( v-- >0) {
            sb.append(k);

                sb.append("+");

        }
    }
        System.out.println(sb.substring(0,sb.length()-1));
}
}