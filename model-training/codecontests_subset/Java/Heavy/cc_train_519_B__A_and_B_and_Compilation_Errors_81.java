

import javafx.print.Printer;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int numeroErrores=teclado.nextInt();

        int n, t;

        int a = 0, b = 0, c = 0;

        for (int i = 0; i < numeroErrores; i++)
        {

            a +=teclado.nextInt();
        }

        for (int i = 0; i < numeroErrores - 1; i++)
        {

            b += teclado.nextInt();
        }

        for (int i = 0; i < numeroErrores - 2; i++)
        {

            c += teclado.nextInt();
        }

        out.print(a - b);
        out.print(" "+ (b - c));
        out.flush();
    }

}