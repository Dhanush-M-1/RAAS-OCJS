public class
Main
{
  private final static int[ ][ ] d = new int[ ][ ] {
    { },
    { 0,    0,  300,  500,  600,  700, 1350, 1650 },
    { 0,  300,    0,  350,  450,  600, 1150, 1500 },
    { 0,  500,  350,    0,  250,  400, 1000, 1350 },
    { 0,  600,  450,  250,    0,  250,  850, 1300 },
    { 0,  700,  600,  400,  250,    0,  600, 1150 },
    { 0, 1350, 1150, 1000,  850,  600,    0,  500 },
    { 0, 1650, 1500, 1350, 1300, 1150,  500,    0 } };
  private final static boolean[ ][ ] f = new boolean[ ][ ] {
    { },
    { false, false,  true,  true,  true,  true, false, false },
    { false,  true, false,  true,  true,  true,  true, false },
    { false,  true,  true, false,  true,  true,  true, false },
    { false,  true,  true,  true, false,  true,  true,  true },
    { false,  true,  true,  true,  true, false,  true,  true },
    { false, false,  true,  true,  true,  true, false,  true },
    { false, false, false, false,  true,  true,  true, false } };

  public void
  run (
    final java.util.Scanner sc,
    final java.io.PrintStream out
    )
  {
    for ( ; ; )
    {
      int s, t;
      int h, m, t1, t2;

      s = sc.nextInt ( );
      if ( s == 0 ) break ;
      h = sc.nextInt ( ); m = sc.nextInt ( );
      t1 = h * 60 + m;
      t = sc.nextInt ( );
      h = sc.nextInt ( ); m = sc.nextInt ( );
      t2 = h * 60 + m;

      if ( f[ s ][ t ]
        && ( ( t1 >= 17 * 60 + 30 && t1 <= 19 * 60 + 30 )
          || ( t2 >= 17 * 60 + 30 && t2 <= 19 * 60 + 30 ) ) )
      {
        out.println ( d[ s ][ t ] / 2 / 50 * 50 + ( ( d[ s ][ t ] / 2 ) % 50 == 0 ? 0 : 50 ) );
      }
      else
      {
        out.println ( d[ s ][ t ] );
      }
    }
  }

  public static void
  main (
    final String[ ] args
    )
  {
    ( new Main ( ) ).run ( new java.util.Scanner ( System.in ), System.out );
  }
}