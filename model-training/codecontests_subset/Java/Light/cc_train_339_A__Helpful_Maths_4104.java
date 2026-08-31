import java.util.Scanner;
import java.util.Arrays;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
Scanner l=new Scanner(System.in);
String numeros=l.nextLine();
int pos=0;
int c[]=new int[(numeros.length()/2)+1];
for (int i = 0; i <c.length; i++) {
c[i]=Integer.parseInt((numeros.substring(pos,pos+1)));
pos=pos+2;
}
Arrays.sort(c);
String res="";
for (int i = 0; i < c.length; i++) {
res=res+c[i]+"+";


}
res=res.substring(0,res.length()-1);
System.out.println(res);
    }
}
