//package com.company;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder outputString = new StringBuilder();

        int position1 = Integer.parseInt(br.readLine());
        int position2 = Integer.parseInt(br.readLine());

        int positionA = Math.min(position1,position2);
        int positionB = Math.max(position1,position2);

        int totalTiredness = 0;

        if((positionB-positionA)%2 == 0)
        {
            int movesOfA = (positionB-positionA)/2;
            int movesOfB = movesOfA;

            totalTiredness = movesOfA*(movesOfA+1);
        }
        else
        {
            int movesOfA = (positionB-positionA)/2;
            int movesOfB = movesOfA;
            int extraMove = 1;

            totalTiredness = movesOfA*(movesOfA+1) + (movesOfA+extraMove);
        }

        outputString.append(totalTiredness);
        bw.write(outputString.toString());
        bw.close();
    }
}
