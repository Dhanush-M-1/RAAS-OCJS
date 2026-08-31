import java.util.*;
public class Bark {
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        int n = cin.nextInt();
        String s1 = new String();
        String s2 = new String();
        int count =0;
        ArrayList<String> arr = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            arr.add(cin.next());

        }
        //System.out.println(arr);
        for(int i=0; i<arr.size(); i++){
            for(int j=0; j<arr.size(); j++){
                s1 = arr.get(i).concat(arr.get(j));
                if(s1.contains(s) ){
                   // System.out.println("Yes");
                    count = 1;
                    break;
                }
//                else{
//                    System.out.println("No");
//                }
            }
        }
        if(count == 1){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
