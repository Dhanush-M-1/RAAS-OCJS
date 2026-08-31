import java.util.*;


public class klub {
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);

        int n = skan.nextInt();
        String gr = skan.next();
        String gr2;
        List<String> list = new ArrayList<>();
        Map<Integer, String> map = new TreeMap<>();

        int max = 0;

        for (int i = 0; i <gr.length()-1; i++) {
                gr2 = Character.toString(gr.charAt(i)) + Character.toString(gr.charAt(i+1));
                list.add(gr2);
        }

        HashSet<String> hsUnique = new HashSet<>(list);
        for (String strElement : hsUnique) {
            int x = Collections.frequency(list, strElement);
            if (x > max){
                max = x;
            }
            map.put(x, strElement);
        }

        System.out.println(map.get(max));
    }
}
