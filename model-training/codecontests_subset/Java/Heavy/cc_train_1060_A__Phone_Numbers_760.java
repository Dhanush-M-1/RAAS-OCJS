import java.util.Scanner;

public class ReadFile {

    public static int numberOfEight(String s){
        int numberOfEight = 0;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '8'){
                numberOfEight++;
            }
        }
        return numberOfEight;
    }
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int length = Integer.parseInt(input.nextLine());
        String line = input.nextLine();
        
        int numberOfNumbers = length/11;
        if(length < 11 || !line.contains("8")){
            System.out.println("0");
            return;
        }
        int numberOfEight = numberOfEight(line);
        if(numberOfNumbers <= numberOfEight){
            System.out.println(numberOfNumbers);
        }else{
            System.out.println(numberOfEight);
        }
    }
}