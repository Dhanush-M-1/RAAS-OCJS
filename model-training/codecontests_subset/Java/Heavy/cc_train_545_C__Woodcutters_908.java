import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        ArrayList<Integer> pos = new ArrayList();
        ArrayList<Integer> height = new ArrayList();
        
        for(int i = 0; i < n; i++){
            pos.add(sc.nextInt());
            height.add(sc.nextInt());
        }
        
        if(n == 1){ 
            System.out.println("1");
        }
        else{
        
            int cut = 2;
            int lastChoice = -1;
            for(int i = 1; i < n - 1; i++){
                // System.out.println(pos.get(i) + " " + height.get(i)); 
                if(lastChoice == -1 || lastChoice == 0){
                    
                    if(pos.get(i) - height.get(i) > pos.get(i - 1)){
                        // System.out.println(pos.get(i) + " left"); 
                        lastChoice = -1;
                        cut++;
                    }
                    else if(pos.get(i) + height.get(i) < pos.get(i + 1)){
                        // System.out.println(pos.get(i) + " right"); 
                        lastChoice = 1;
                        cut++;
                    }
                    else
                        lastChoice = 0;
                }
                else{
                    if(pos.get(i - 1) + height.get(i - 1) < pos.get(i) - height.get(i)){
                        // System.out.println(pos.get(i) + " left"); 
                        lastChoice = -1;
                        cut++;
                    }
                    else if(pos.get(i) + height.get(i) < pos.get(i + 1)){
                        // System.out.println(pos.get(i) + " right"); 
                        lastChoice = 1;
                        cut++;
                    }
                    else
                        lastChoice = 0;
                }
            }
            System.out.println(cut);
        }
     }
}