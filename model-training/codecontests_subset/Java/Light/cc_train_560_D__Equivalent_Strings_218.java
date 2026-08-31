import java.util.Scanner;

public class cf559b{
    public static boolean AreEquiv(String strA,String strB){
        if(strA.equals(strB))return true;
        else{
            if(strA.length()%2==0) {
                int halfLength=strA.length()>>1;
                String strA1 = strA.substring(0,halfLength);
                String strA2 = strA.substring(halfLength,strA.length());
                String strB1 = strB.substring(0,halfLength);
                String strB2 = strB.substring(halfLength,strA.length());
                //System.out.println(strA1+" "+strA2+" "+strB1+" "+strB2);
                return ((AreEquiv(strA1,strB2) && (AreEquiv(strA2,strB1)))
                ||(AreEquiv(strA1,strB1) && (AreEquiv(strA2,strB2))));
            }else return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mainStringA = in.next();
        String mainStringB = in.next();

            if (AreEquiv(mainStringA, mainStringB)) System.out.println("YES");
            else System.out.println("NO");

        in.close();
    }
}