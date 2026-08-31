import java.util.*;

public class Main {

  public static void main(String args[]) {
    int rep = 1;
    if( args.length > 0 ) { rep = Integer.parseInt(args[0]); }
    (new Main()).__solve(rep);
  }

  void __solve(int rep) {

    try (
      Scanner cin = new Scanner(System.in);
    ) {

      for( int i = 0; i < rep; ++i ) {
        __solve(cin);
      }

    }

  }

  void __solve(Scanner cin) {

	  int N = cin.nextInt();
	  int K = cin.nextInt();
	  int Q = cin.nextInt();
	  
	  int array[] = new int[N];
	  
	  Pair pairs[] = new Pair[N];
	  
	  for( int i = 0; i < N; ++i ) {
		  array[i] = cin.nextInt();
	  }
	  
	  for( int i = 0; i < N; ++i ) {
		  int value = array[i];
		  int rest = K - 1;
		  int min = value;
		  int L = i - 1;
		  int R = i + 1;
		  while( rest > 0 ) {
			  if( L >= 0 && R < N ) {
				  if( array[L] < array[R] ) {
					  if( array[R] >= value ) {
						  --rest;
					  }
					  min = Math.min(min, array[R]);
					  ++R;
				  }
				  else {
					  if( array[L] > value ) {
						  --rest;
					  }
					  min = Math.min(min, array[L]);
					  --L;
				  }
			  }
			  else if( L >= 0 ) {
				  if( array[L] > value ) {
					  --rest;
				  }
				  min = Math.min(min, array[L]);
				  --L;
			  }
			  else if( R < N ) {
				  if( array[R] >= value ) {
					  --rest;
				  }
				  min = Math.min(min, array[R]);
				  ++R;
			  }
			  else {
				  // cannot remove this;
				  min = -1;
				  break;
			  }
		  }
		  pairs[i] = new Pair(value, min);
	  }
	  
	  Arrays.sort(pairs);
	  int ret = pairs[N - 1].value - pairs[0].value;

	  MAIN:
	  for(int i = 0; i + Q < N; ++i ) {
		  int start = pairs[i].value;
		  int index = i;
		  for(int j = 0; j < Q; ++j ) {
			  while( index < N && pairs[index].min < start ) { ++index; }
			  if( index == N ) { continue MAIN; }
			  if( j == Q - 1 ) {
				   ret = Math.min(ret, pairs[index].value - start);
			  }
			  ++index;
		  }
	  }
	  
	  System.out.println(ret);
	  
  }
  
  class Pair implements Comparable<Pair> {
	  int value;
	  // removed minimum value;
	  int min;
	  
	  Pair(int value, int min) {
		  this.value = value;
		  this.min = min;
	  }
	  
	  @Override
	  public int compareTo(Pair p) {
		  if( p.value > value ) { return -1; }
		  if( p.value < value ) { return 1; }
		  if( p.min > min ) { return 1; }
		  if( p.min < min ) { return -1; }
		  return 0;
	  }
  }

}
