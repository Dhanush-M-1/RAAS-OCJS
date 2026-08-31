import java.util.*;
import java.math.*;

public class Main {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int c = sc.nextInt();
int diff = 0;
int prev = 0;
for (int i=0; i<n; i++){
  int x = sc.nextInt();
  int y = prev - x;
  diff = Math.max(diff,y);
  prev = x;
}
System.out.println(Math.max(diff-c,0));

}
}
