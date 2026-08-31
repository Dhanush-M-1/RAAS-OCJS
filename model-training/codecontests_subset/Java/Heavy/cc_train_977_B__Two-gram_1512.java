import java.util.Scanner;
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt(), max=0;
        in.nextLine();
        String s=in.nextLine(), o, ans="";
        Map<String,Integer> m=new HashMap<String,Integer>();
        for(int i=1;i<s.length();i++){
            o=s.substring(i-1,i+1);
            if(m.get(o)==null){
                m.put(o,1);
            }
            else{
                int x=m.get(o);
                x++;
                m.put(o,x);
            }
            if(max<m.get(o)){
                max=m.get(o);
                ans=o;
            }
        }
        System.out.print(ans);
    }
}
