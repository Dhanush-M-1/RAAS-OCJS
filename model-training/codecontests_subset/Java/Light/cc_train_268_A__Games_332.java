import java.util.ArrayList;
import java.util.Scanner;

public class Games {

    public static void main(String[] args) {
Scanner s=new Scanner(System.in);
int num=s.nextInt();
ArrayList<Integer> a=new ArrayList();
ArrayList<Integer> b=new ArrayList();
int count=0;
 for (int i = 0; i < num; i++) {
     int x=s.nextInt();
     int y=s.nextInt();

     a.add(x);
     b.add(y);
 }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(a.get(i)==b.get(j))
                count++;
            }
        }

        System.out.println(count);
    }
    
}
