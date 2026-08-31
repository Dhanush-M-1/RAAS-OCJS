    import java.util.*;
    public class K_S{
        public static void main(String arg[]){
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           String s = sc.next();
           char ch[] = s.toCharArray();
           int co=0,cz=0;
           List<Integer> list = new ArrayList<>();
               for(int i=0; i<n; i++){
                   list.add(Integer.parseInt(Character.toString(ch[i])));
                    if(list.get(i)==1)
                      co++;
                    else
                      cz++;
               }
               if(co!=cz){
                   System.out.println("1");
                   System.out.println(s);
               }
               else
               {
                   System.out.println("2");
                   System.out.print(list.get(0)+" ");
                   list.remove(list.get(0));
                   for(int i :list)
                   System.out.print(i);
                   System.out.println();
               }
           }
        
    }