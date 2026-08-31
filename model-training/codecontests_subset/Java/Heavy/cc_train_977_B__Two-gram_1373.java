
import java.util.*;
public class JavaApplication74 {

    
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        int n=read.nextInt();
        String word=read.next();
        Map<String,Integer> dic=new HashMap<String,Integer>();
        if(word.length()==2||word.length()==3){
            System.out.println(word.charAt(0)+""+word.charAt(1));
        }
        else{
        int rp=0;
        int lp=1;
        int i=0;
        int j=1;
        
        while(lp<n-1){
             String s=word.charAt(rp)+""+word.charAt(lp);
             String s2=word.charAt(i)+""+word.charAt(j);
             if(dic.containsKey(s)==false){
             dic.put(s,0);
             }
            
             if(s.equals(s2)){
             dic.replace(s,dic.get(s)+1);
             }
             if(j==n-1){
             rp++;
             lp++;
             i=0;
             j=1;
             }
             i++;
             j++;
        }
        
         Map.Entry<String,Integer> max=null;
         for(Map.Entry<String,Integer> x:dic.entrySet()){
             if (max == null || x.getValue().compareTo(max.getValue()) > 0)
    {
        max = x;
    }
         }

         String re=(max+"");
         System.out.println(re.charAt(0)+""+re.charAt(1));
        }
    }
    
}
