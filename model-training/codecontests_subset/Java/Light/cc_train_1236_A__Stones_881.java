import java.util.*;
public class Test{

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      int test = sc.nextInt();
      for(int i=0; i<test;i++){
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int count =0;
        while(c-2>=0 && b-1>=0){
            c -= 2;
            b -=1;
            count += 3;
        }
        while(a-1>=0 && b-2>=0){
            b -= 2;
            a -= 1;
            count += 3;
        }
        System.out.println(count);
      }
    }
}
