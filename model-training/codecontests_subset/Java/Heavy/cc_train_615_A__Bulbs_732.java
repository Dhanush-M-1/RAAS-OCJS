import java.util.Scanner;
import java.util.LinkedList;
public class Main{
    public static void main(String args[]){
    	Scanner s = new Scanner(System.in);
        String y = s.nextLine();
        int a = Integer.parseInt(y.split(" ")[0]);
        int b = Integer.parseInt(y.split(" ")[1]);
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=1;i<=b;i++) ll.push(i);
        for(int i=0;i<a;i++){
            String line = s.nextLine();
            String val[] = line.split(" ");
            int arr[] = new int[val.length];
            for(int j=1;j<val.length;j++){
                arr[j] = Integer.parseInt(val[j]);
                Integer z = new Integer(arr[j]);
                if(ll.contains(z)) ll.remove(z);
            }
            
        }
        if(ll.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
            
    }
}