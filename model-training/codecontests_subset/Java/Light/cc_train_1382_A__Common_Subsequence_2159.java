import java.util.*;
public class main{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- >0){
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> arr = new HashSet<Integer>();
        for(int i =0; i<n;i++){
            arr.add(sc.nextInt()) ;
        }
        boolean b = false;
        for(int i = 0; i< m;i++){
            int temp = sc.nextInt();
            if(!b && arr.contains(temp)){
                System.out.println("YES");
                System.out.println("1" + " "+ temp);
                b = true;
               
                
            }
        }
        if(!b){
            System.out.println("NO");
        }
    }
    }
}