import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> onlineUsers = new ArrayList<>();
        int accumulate = 0;
        while(scanner.hasNext()){
            String temp =  scanner.nextLine();
            if(temp.charAt(0)=='+' && !onlineUsers.contains(temp.substring(1, temp.length())))
                onlineUsers.add(temp.substring(1, temp.length()));
            else if (temp.charAt(0)=='-' && onlineUsers.contains(temp.substring(1, temp.length()))) 
                onlineUsers.remove(temp.substring(1, temp.length()));
            else 
                accumulate += (onlineUsers.size() * temp.substring(temp.indexOf(':')+1, temp.length()).length());
        }
        System.out.println(accumulate);
    }
}