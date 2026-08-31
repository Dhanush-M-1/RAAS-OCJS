import java.util.Scanner;

public class Main {
    public static void main(String[] argv){
        Scanner in = new Scanner(System.in);
        String buf;
        int averageUsers = 0;
        int averageTraffic = 0;

        while(in.hasNext()){
            buf = in.nextLine();

            if(buf.startsWith("+")){
                averageUsers++;
            }
            else if(buf.startsWith("-")){
                averageUsers--;
            }
            else{
                try{
                    averageTraffic += (buf.split(":")[1].length() * (averageUsers));
                }
                catch (Exception e){
                    
                }
                
            }
        }
        System.out.println(averageTraffic);
        in.close();
    }
}