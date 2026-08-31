import java.util.*;

public class Main{
    static class Pair{
        String first;
        String second;
        Pair(String f,String s){
            this.first = f;
            this.second = s;
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        ArrayList<Pair> list = new ArrayList<>();
        
        String s1 = scn.next();
        String s2 = scn.next();
        
        list.add(new Pair(s1,s2));
        int n = scn.nextInt();
        
        for(int i=1;i<=n;i++){
            s1 = scn.next();
            s2 = scn.next();
            list.add(new Pair(s1,s2));
        }
        System.out.println(list.get(0).first +" " +list.get(0).second);
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).first.equals(list.get(i).first)){

                list.get(i).first = list.get(i).second;
                list.get(i).second = list.get(i-1).second;
                
            }else if(list.get(i-1).second.equals(list.get(i).first)){
                list.get(i-1).second = list.get(i).second;
                list.get(i).first = list.get(i-1).first;
                
            }
            System.out.println(list.get(i).first +" " + list.get(i).second);
            
            
        }
        
    }
}