import java.util.*;
public class Memory {
     static int start = 0;
 public static void main(String[] args){
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int m = in.nextInt();
     int index = 0;
     ArrayList<Integer> state = new ArrayList<Integer>();
     for(int i = 0; i < m ; i++)
         state.add(0);
     ArrayList<Integer> deleteIndex = new ArrayList<Integer>();
     for(int i = 0 ; i < n ; i++){
         String s = in.next();
         if(s.equals("alloc")){
             int size = in.nextInt();
             if(check(state,size)){
                 index++;
                 for(int j = start; j < start + size; j++){
                    state.set(j, index);
                 }
                 System.out.println(index);
             }
             else
                 System.out.println("NULL");
         }
         else if(s.equals("erase")){
            int tempindex = in.nextInt();
            int starterase = -1;
            if(tempindex > 0 && tempindex <= index && !deleteIndex.contains(tempindex)){
                for(int j = 0 ; j < state.size(); j++){
                    if(tempindex == state.get(j)){
                        starterase = j;
                            while(state.get(starterase) == tempindex){
                                state.set(starterase, 0);
                                starterase++;
                                if(starterase == state.size())
                                    break;
                            }
                        break;
                       }
                }
                deleteIndex.add(tempindex);
            }
            else
                System.out.println("ILLEGAL_ERASE_ARGUMENT");
         }
         else if(s.equals("defragment")){
                while(state.contains((Object)0))
                 state.remove((Object)0);
                while(state.size() < m)
                    state.add(0);
         }
     }
 }
 public static boolean check(ArrayList<Integer> s,int size){
     int begin = 0;
     int length = 0;
     int i = 0;
     while(begin < s.size()){
         if(i == s.size())
             break;
         length = 0;
         for(i = begin; i < s.size(); i++){
             if(s.get(i) == 0){
                 length++;
                 if(length == size){
                     start = begin;
                     return true;
                 }
             }
             else{
                 begin = i + 1;
                 break;
             }
         }
     }
         return false;
 }
}
