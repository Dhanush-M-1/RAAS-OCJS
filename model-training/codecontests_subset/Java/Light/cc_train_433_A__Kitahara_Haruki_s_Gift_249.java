import java.util.*;
public final class Main {
  public static void main(String[] args) {

    Scanner inputUser = new Scanner(System.in);
    Integer n = inputUser.nextInt();

    ArrayList<Integer> v = new ArrayList<>();
    for (int i=0;i<n; ++i) {
        int aux = inputUser.nextInt();
        v.add(aux);
    }
    Collections.sort(v);


    int a = 0;
    int b = 0;
    for (int i=n-1; i >=0;--i) {
        if (b > a)
            a += v.get(i);
        else 
            b+= v.get(i);
    }

    if (a == b)
        System.out.println("YES");
    else
        System.out.println("NO");
    
  }
}
	 	 				  	 	  	 		  					 	 	