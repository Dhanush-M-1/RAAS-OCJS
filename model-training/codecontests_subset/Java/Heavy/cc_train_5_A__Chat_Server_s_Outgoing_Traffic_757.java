

import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countMessage = 0;
        int countUser = 0;
        while (scanner.hasNextLine()){
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("+")){
                countUser++;
                continue;
            }
            if (nextLine.startsWith("-")){
               countUser--;
                continue;
            }
            if (nextLine.contains(":")){
                int index = nextLine.indexOf(":");
                String message = nextLine.substring(index+1);

                countMessage= countMessage+message.length()*countUser;

                continue;
            }
            if(nextLine.length()==0) break;
        }
        System.out.println(countMessage);
    }
}

