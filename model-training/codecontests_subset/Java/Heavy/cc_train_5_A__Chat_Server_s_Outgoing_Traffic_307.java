import java.util.Scanner;

public class Server {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str[]=new String[101];
        int c=0;
        int traffic=0;
        int count=0;
        int cc=0;
        String strTemp[];
       while(sc.hasNextLine() ){
            str[count++]=sc.nextLine();
         
        }

        for(int i=0;i<count;i++){
            if(str[i].charAt(0)=='+' ){
                c++;
            }
            else if(str[i].charAt(0)=='-'){
                c--;
            }
            else{
                strTemp=str[i].split(":");
                if(strTemp.length>1)
                traffic = traffic+c*strTemp[1].length();
                
            }
        }
        System.out.println(traffic);

    }
}
