//package contest_21_11_20114;

import java.util.Scanner;

public class C {
public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
     int yHP = sc.nextInt();
     int yATK = sc.nextInt();
     int yDEF = sc.nextInt();

     int mHP = sc.nextInt();
     int mATK = sc.nextInt();
     int mDEF = sc.nextInt();

     int cHP = sc.nextInt();
     int cATK = sc.nextInt();
     int cDEF = sc.nextInt();


     long totCost = Long.MAX_VALUE;
     for(int i = 0; i < 300; i++) {
         for(int j = 0; j < 300; j++) {
             int dmgDone = Math.max(0, (yATK + i - mDEF));
             int dmgRcvd = Math.max(0, (mATK - j - yDEF));

             if(dmgDone == 0) continue;
             int turnsToWin = (int) Math.ceil((double) mHP / dmgDone);

             int rHP = (turnsToWin * dmgRcvd) + 1;
             int extraHP = rHP > yHP? rHP - yHP: 0;

             long cost = (i * 1L * cATK) + (j * 1L * cDEF) + (extraHP * 1L * cHP);
             totCost = Math.min(cost, totCost);

         }
     }

     System.out.println(totCost);
}
}
