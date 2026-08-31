import java.util.Scanner;
public class Main{
    public static void main(String args[]){
       //Getting and Storing inital possible Victims.
       String vicA = Main.read.next(),vicB = Main.read.next();
        //Days.
       int days = Main.read.nextInt();
       //Constructing serial Killer.
       SerialKiller hannibal = new SerialKiller(vicA,vicB);
       //For Storing potenial Victims of each Day.
       String [][] victimsArray = new String [days+1][2];
       //Potential Victims of First Day.
       victimsArray[0][0] = vicA;
       victimsArray[0][1] = vicB;
       //Let the Killing Commence.
       for (int x = 1;x<victimsArray.length;++x){
        //Determining Tomorows Victims.
        hannibal.computeFuturePotentialVictims(Main.read.next(),Main.read.next());
        //Storing Tomorows Victims. 
        victimsArray[x][0] = hannibal.getPotentialVictimA();
        victimsArray[x][1] = hannibal.getPotentialVictimB(); 
       }
       //Printing Vicitms.
       for (int x =0 ;x<victimsArray.length;++x){
         System.out.println(victimsArray[x][0]+" "+victimsArray[x][1]);
       }
    }
    public static Scanner read = new Scanner(System.in);
}
class SerialKiller {
    //To detemine victims of the following day.
    void computeFuturePotentialVictims(String murderd,String newPotentialVictim){
        if (murderd.equals(this.potentialVictimA)){
            this.potentialVictimA = newPotentialVictim;
        }
        else{
            this.potentialVictimB = newPotentialVictim;
        }
    }
    //To retrive victim A.
    public String getPotentialVictimA() {
        return potentialVictimA;
    }
    //To retiver victim B.
    public String getPotentialVictimB() {
        return potentialVictimB;
    }
    //Constructor.
    SerialKiller(String vicA,String vicB){
        this.potentialVictimA = vicA;
        this.potentialVictimB = vicB;
    }
    //For Storing possible victims.
    private String potentialVictimA = "",potentialVictimB = "";
}