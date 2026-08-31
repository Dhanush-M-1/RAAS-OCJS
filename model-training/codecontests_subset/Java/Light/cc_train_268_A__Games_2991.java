import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> home = new ArrayList<Integer>();
        ArrayList<Integer> guest = new ArrayList<Integer>();
        int count = 0;
        for(int i=0;i<n;i++){
            home.add(in.nextInt());
            guest.add(in.nextInt());
        }
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(home.get(i) == guest.get(j)){
                   count++;
               }
           }
       }
       System.out.println(count);
    }
}