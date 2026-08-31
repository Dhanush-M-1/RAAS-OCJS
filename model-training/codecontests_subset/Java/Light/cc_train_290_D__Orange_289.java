import java.util.Scanner;


public class Main {

    /**
     * @param args
     */
    static Scanner leer=new Scanner(System.in);
    public static void main(String[] args) {
        String cad=leer.nextLine();
        int n=Integer.valueOf(leer.nextLine());
        cad=cad.toLowerCase();
        String cad2="";
        for(int i=0;i<cad.length();i++)
        {
            char c=cad.charAt(i);
            if((int)(c)<n+97)
            {
                cad2=cad2+(char)(c-32);
            }
            else
                cad2=cad2+c;
        }
        System.out.println(cad2);   

    }

}
