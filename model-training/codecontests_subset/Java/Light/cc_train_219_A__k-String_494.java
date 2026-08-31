import java.util.*;
public class Main {
    public static Scanner sn = new Scanner(System.in);
    
    public static void main (String[] args){
        while (sn.hasNext()) {
            int n = Integer.parseInt(sn.next());
            String m = sn.next();
            boolean b = true;
            HashMap<Character, Integer> data = new HashMap<>(); 
            for(int i = 0; i < m.length(); i++){
                char o = m.charAt(i);
                if(data.containsKey(o)){
                     data.put(m.charAt(i), data.get(m.charAt(i))+1);
                }else{
                    data.put(o, 1);
                }
            }
            
            for(Character i : data.keySet())
                if(data.get(i) % n != 0)
                    b = false;
            
            //System.out.println(data);
            if(b == false)
                System.out.println("-1");
            else{
                String result = "";
                for (Character string : data.keySet())
                    data.put(string, data.get(string) / n);
                
                for (Character string : data.keySet())
                    for (int i = 0; i < data.get(string); i++)
                        result += string;
                
                String copy = result;
                
                for (int i = 1; i < n; i++)
                    result += copy;
                
                System.out.println(result);
            }
        }
        
    }
}
