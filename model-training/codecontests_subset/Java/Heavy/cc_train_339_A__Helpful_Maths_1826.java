import java.util.*;
public class java{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<s.length();i+=2){
            int n = s.charAt(i)-'0';
            l.add(n);
        }
        Collections.sort(l);
        String res="";
        int i = 0;
        if(l.size()>1){
        while(i<l.size()){
            String o = Integer.toString(l.get(i));
            res+=o;
            if(i+1<l.size()){
            String e = Integer.toString(l.get(i+1));
            res = res+"+"+e;
            if((l.size()-(i+1))>1)
            res+="+";
            }
            i=i+2;
        }
        System.out.println(res);
        }
        else
        System.out.println(l.get(0));
    }
}