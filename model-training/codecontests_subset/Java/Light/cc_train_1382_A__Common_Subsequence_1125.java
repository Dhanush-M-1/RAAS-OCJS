import java.util.*;

public class CommonSubSeq {
    public static Scanner sc = new Scanner(System.in);
    
    static void solve(){
      int n = sc.nextInt();
      int m = sc.nextInt();
      List<Integer> A = new ArrayList<>();
      List<Integer> B = new ArrayList<>();
      for(int i = 0;i<n;i++){
          A.add(sc.nextInt());
      }
      for(int i = 0;i<m;i++){
        B.add(sc.nextInt());
    }
    int a = 1; int b = 0;boolean found = false;
    for(int var : B){
         if(A.contains(var)){
            b = var;
            found = true;           
            break;
        }
    }    
        if(found == false){
                System.out.println("NO");
        } else{
            System.out.println("YES");
            System.out.println(a+" "+b);
        }
    }
    
    public static void main(String[] args) {
        int test = sc.nextInt();
        while(test --> 0){
            solve();
        }
    }
}