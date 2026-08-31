import java.util.Scanner;

public class ChatServer {
    public static void main(String[] param){
        Scanner s=new Scanner(System.in);
        int num=0;
        int k=0;
        while(s.hasNext()){
            String st=s.nextLine();
        if(st.startsWith("+"))
            k++;
        else if(st.startsWith("-"))
            k--;
        else {
            int i = st.indexOf(':');
            //System.out.println("i="+i);
            num =num+ k*(st.length() - i-1);
            //System.out.println("num="+num);
        }

        }
        System.out.println(num);
    }
}
