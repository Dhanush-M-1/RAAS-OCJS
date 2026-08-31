import java.util.*;

public class Test{
public static void main(String[] args){
Scanner input = new Scanner(System.in);
int bacteria = input.nextInt();
int konst = input.nextInt();
input.nextLine();
ArrayList<Integer> bac = new ArrayList<>();
for (int i = 0; i < bacteria; i++){
    bac.add(input.nextInt());
}

Collections.sort(bac);

int result = bac.size();

for (int i = 0, a = 0; i < bac.size(); i++){
    while (a < bac.size() && bac.get(i) >= bac.get(a)){
        a++;
    }
    if (a < bac.size() && bac.get(a) - bac.get(i) <= konst){
        result--;
    }
}

System.out.println(result);

}


}