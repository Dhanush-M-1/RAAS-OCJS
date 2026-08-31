import java.util.Scanner;

public class Main{
    private static int count_elements(String line, char separate_element){
        int counter = 0;
        for(int index = 0; index < line.length(); index++){
            if(line.charAt(index) == separate_element)
                counter++;
        }
        return counter + 1;
    }

    private static int[] to_array(String line, char separate_element){
        int array[] = new int[count_elements(line, separate_element)], counter = 0;
        String number = "";
        for(int index = 0; index < line.length(); index++){
            if(line.charAt(index) != separate_element)
                number += line.charAt(index);
            else if(line.charAt(index) == separate_element){
                array[counter] = Integer.parseInt(number);
                number = "";
                counter++;
            }
        }
        array[counter] = Integer.parseInt(number);
        return array;
    }
    
    private static int get_index(int value, int array[]){
        int rememb_index = 0;
        for(int index = 0; index < array.length; index++)
            if(value == array[index]) {
                rememb_index = index;
                index = array.length - 1;
            }
        return rememb_index;
    }

    private static int min(int array[]){
        int min = array[0];
        for(int element : array)
            if(element < min)
                min = element;
        return min;
    }

    private static int max(int array[]){
        int max = array[0];
        for(int element : array)
            if(element > max)
                max = element;
        return max;
    }

    private static boolean all_equals(int array[]){
        boolean result = false;
        int counter = 0, first_element = array[0];
        for(int index = 0; index < array.length; index++)
            if(array[index] == first_element)
                counter++;
        if(counter == array.length)
            result = true;
        return result;
    }

    private static int get_initial_rate(int array[]){
        boolean contin = !all_equals(array);
        int rate = -1;
        if(all_equals(array) &&  array[0] != 0)
            rate = array[0];
        else {
            while (contin) {
                array[get_index(min(array), array)]++;
                array[get_index(max(array), array)]--;
                if (all_equals(array)) {
                    rate = array[0];
                    contin = false;
                } else if (max(array) - min(array) == 1)
                    contin = false;
            }
        }
        return rate;
    }

    public static void solve() {
        String line;
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        System.out.println(get_initial_rate(to_array(line, ' ')));
    }
    
    public static void main(String[] args){
        solve();
    }
}

