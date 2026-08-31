import java.util.*;

public class HelpfulMath {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int c1 =0;
        int c2 =0;
        int c3 =0;
        String sol = "";

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                c1++;
            }
            else if (s.charAt(i) == '2'){
                c2++;
            }
            else if (s.charAt(i) == '3'){
                c3++;
            }

        }
      for(int j=0;j<c1;j++){
            sol = sol + "1+";
      }
      for(int j=0;j<c2;j++){
          sol = sol + "2+";
      }
      for(int j=0;j<c3;j++){
          sol = sol + "3+";
      }
        sol = sol.substring(0,s.length());
        System.out.println(sol);

}
}
