import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int active=0,traf=0;
        while(in.hasNext())
        {
            String Line=in.nextLine();          
            if(Line.charAt(0)=='+')
                active++;
            else if(Line.charAt(0)=='-')
                active--;
            else
            {
                int index=Line.indexOf(":");
                traf+=(active*(Line.substring(index+1, Line.length()).length()));
            }               
        }
        System.out.println(traf);

    }

}
