import java.util.Scanner;
import java.util.ArrayList;
public class pom {
    public static void main(String[] arg) {
      Scanner sc =new Scanner(System.in);
      String num = sc.nextLine();
      String string = sc.nextLine();
      ArrayList<Integer>mlist = new ArrayList<>();
      int o =0;
      int sum =0;
      int sum1=0;
      for(int i = 0; i<string.length();++i){
          if(string.charAt(i)==' '){
              mlist.add(Integer.parseInt(string.substring(o,i)));
              o = i+1;

          }
          else if(i+1==string.length()){
              mlist.add(Integer.parseInt(string.substring(o,i+1)));
                    o = 0;
          }
      }
      for(int i =0;i<mlist.size();++i){
          sum1+= mlist.get(i);

      }
   for (int i =1;i<mlist.size();++i){
          if(mlist.get(i)> mlist.get(o))
          o = i;
   }
   int max = mlist.get(o);
      for(int i =0;i<mlist.size();++i){
          sum+=(max-mlist.get(i));
      }


      while (sum<=sum1){
          ++max;
            sum = 0;
          for(int i =0;i<mlist.size();++i){
              sum+=(max-mlist.get(i));
          }


      }
   
        System.out.println(max);

    }
}
