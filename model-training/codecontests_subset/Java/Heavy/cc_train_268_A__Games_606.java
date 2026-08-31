import java.util.*; 
public class Main {
  public static void main(String[] args) {
 
 //   System.out.println("Hello world!");
    Scanner sc = new Scanner(System.in);

    int team = sc.nextInt(); 
    int[][] array = new int[team][2]; 

    for(int i=0; i<array.length; i++){ 
      for(int j=0; j<array[i].length; j++){
        array[i][j] = sc.nextInt(); 
      }
    }
    int home1 = 0;
    int guest1 = 0;
    int home2 = 0;
    int guest2 = 0;
    int count = 0;

    for(int i=0; i<team; i++){
      for(int j=i+1; j<team; j++){
        home1 = array[i][0]; 
        guest1 = array[i][1]; 
        home2 = array[j][0]; 
        guest2 = array[j][1]; 
        if(home1 == guest2)count++; 
        if(guest1 == home2)count++; 
      }
    }


 
    System.out.println(count); 
  }
}