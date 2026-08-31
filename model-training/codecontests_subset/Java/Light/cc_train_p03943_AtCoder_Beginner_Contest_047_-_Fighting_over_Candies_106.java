import java.util.*;
public class Main {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int n[] = new int[3];
      for(int i=0;i<3;i++){
        n[i]=Integer.parseInt(scan.next());
      }
      if(n[0]+n[1]==n[2]||n[0]+n[2]==n[1]||n[1]+n[2]==n[0]){
        System.out.println("Yes");
      }else{
        System.out.println("No");
      }
    }
}
