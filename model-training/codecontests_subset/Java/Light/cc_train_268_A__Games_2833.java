import java.util.*;
public class Games {

private static Scanner sc;
public static void main(String[] args) {
    sc = new Scanner (System.in);
    int n = sc.nextInt();
    int counter = 0;
    int [] home = new int [n];
    int [] geust = new int [n];
    for (int i = 0;i<n;i++)
    {
     home[i]=sc.nextInt();
     geust[i]= sc.nextInt();
    }
    for (int i =0;i<n;i++)
    {
        for (int j=0;j<n;j++)
        {
          if (home[i]==geust[j])
            counter++;
        }
    }
   System.out.println(counter);

     
    
}
}
