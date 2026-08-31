
import java.util.ArrayList;
import java.util.Scanner;

public class P7B {

    ArrayList<Integer> index = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    ArrayList<Integer> start = new ArrayList<>();
    int number = 0;
    int vol;
    void memory (){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        vol = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++){
            String line = sc.nextLine();
            if (line.startsWith("alloc")){
                int val = Integer.parseInt(line.split("\\s+")[1]);
                alloc(val);
            }
            else if (line.startsWith("erase")){
                int val = Integer.parseInt(line.split("\\s")[1]);
                erase (val);
            }
            else if (line.startsWith("defragment")){
                defragment();
            }
        }
        sc.close();
    }

    void alloc (int mem){
        boolean added = false;
        if (size.isEmpty()){
            if (mem <=vol){
                start.add(0);
                size.add(mem);
                number++;
                index.add(number);
                added = true;
                System.out.println(number);
                return;
            }
        }
        else {
            if (start.get(0) >= mem){
                start.add(0, 0);
                size.add(0, mem);
                number ++;
                index.add(0, number);
                added = true;
                System.out.println(number);
                return;
            }

            for (int i = 1; i < size.size() && !added; i++){
                if (start.get(i) - (start.get(i-1) + size.get(i-1)) >= mem){
                    start.add(i, start.get(i-1) + size.get(i-1));
                    size.add(i, mem);
                    number++;
                    index.add(i, number);
                    added = true;
                    System.out.println(number);
                    return;
                }
            }

            if (added == false && ! start.isEmpty() &&
                    vol - (start.get(index.size()-1) + size.get(size.size()-1)) >= mem){
                added = true; 
                number ++;
                start.add(start.get(start.size()-1) + size.get(size.size()-1));
                index.add(number);
                size.add(mem);
                System.out.println(number);
                return;
            }
        }

        System.out.println("NULL");
    }

    void erase (int ind){
        if (!index.contains(ind)){
            System.out.println("ILLEGAL_ERASE_ARGUMENT");
        }
        else {
            size.remove(index.indexOf(ind));
            start.remove(index.indexOf(ind));
            index.remove(index.indexOf(ind));
        }
    }

    void defragment (){
        if (!start.isEmpty() && start.get(0) > 0){
            start.set(0, 0);
        }
        for (int i = 1; i < start.size(); i++){
            start.set(i, start.get(i-1) + size.get(i-1));
        }
    }

    public static void main (String []args){
        P7B p = new P7B();
        p.memory();
    }
}
