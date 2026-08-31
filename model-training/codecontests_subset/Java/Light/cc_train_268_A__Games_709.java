import java.util.*;
public class Games {
  
 public static void main(String[] args)
 {
  Scanner in = new Scanner(System.in);
  int teams = in.nextInt(), home[] = new int[teams], guest[] = new int[teams], count = 0;
  for (int i = 0; i < teams; i++){
  home[i] = in.nextInt();
  guest[i] = in.nextInt();
  }
  for (int i = 0; i < teams; i++){
  for (int j = 0; j < teams; j++){
  if (home[i] == guest[j]) count++;
  }
  }
  System.out.println(count);
  
 }

}
