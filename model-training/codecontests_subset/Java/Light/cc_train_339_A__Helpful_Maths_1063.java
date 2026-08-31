import java.util.*;
public class java{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<s.length();i=i+2){
            int x=Character.getNumericValue(s.charAt(i));
            l.add(x);
        }
        
        Collections.sort(l);
        for(int i=0;i<l.size();i++){
            System.out.print(l.get(i));
            if(i<l.size()-1)
            System.out.print("+");
        }
        
    }
}