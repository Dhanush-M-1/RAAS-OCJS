import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        int n = sc.nextInt();
        String dog = "";
        if (n==1) {
            String get = sc.next();
            dog = get + get ;
            if (dog.contains(pass))
                System.out.println("YES");
            else
                System.out.println("NO");
        }else {
            String[] words = new String[n];
            boolean find = false;
            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dog = words[i] + words[j];
                    if (dog.contains(pass)){
                        find = true;
                        break;
                    }
                }
            }
            if (find)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }
}

	  	  	   	   			        	 	 	