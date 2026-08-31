import java.util.Scanner;

public class Codeforces5A {

    /**
     * @param args
     */                                                                                                             
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        //List<String> nameList = new ArrayList<String>();
        
        //message length
        int l = 0;
        int size = 0;
        
        while (in.hasNextLine())
        {
            String line = in.nextLine();
            char operator = line.charAt(0);
            
            if (operator == '+') {
                //add
                //nameList.add(line.substring(1));
                size++;
            } else if (operator == '-') {
                //remove
                //nameList.remove(line.substring(1));
                size--;
            } else {
                //send
                int index = line.indexOf(':') + 1;
                int length = line.substring(index).length(); 
                l = l + (length * size);
            }
        }
        in.close();
        System.out.println(l);
    }
}