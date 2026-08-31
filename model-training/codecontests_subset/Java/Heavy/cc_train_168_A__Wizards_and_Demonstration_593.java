import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WizardsAndDemonstrations {
    public static void main(String[] args)throws IOException {
        numOfClones();
    }
    public static void numOfClones()throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String[] input=reader.readLine().split(" ");
        double n=Double.parseDouble(input[0]);
        double x=Double.parseDouble(input[1]);
        double y=Double.parseDouble(input[2]);
        double remPeople=(y/100-(x/n))*n;
        if(remPeople>0&&remPeople<1){
            System.out.println(String.format("%.0f",Math.ceil(remPeople)));
        }
        else {
            if(remPeople==0||remPeople<0){
                System.out.println(0);
            }
            else {
                remPeople=Math.floor(remPeople);
                if((x+remPeople)/n>=y/100){
                    System.out.println(String.format("%.0f",remPeople));
                }
                else {
                    System.out.println(String.format("%.0f",remPeople+1));
                }
            }
        }
    }
}
