#include <iostream>
#include <cstdlib>
using namespace std;
const static int SEQ_LEN_MAX = 100;

int main() {
  while( 1 ) {
    int n, seq[ SEQ_LEN_MAX ];
    cin >> n;
    if( !n ) { return EXIT_SUCCESS; }
    for( int i = 0; i < n; i++ ) {
      cin >> seq[ i ];
    }
    int counter = 0;
    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < n - i - 1; j++ ) {
        if( seq[ j ] > seq[ j + 1 ] ) {
          int k = seq[ j + 1 ];
          seq[ j + 1 ] = seq[ j ];
          seq[ j ] = k;
          counter++;
        }
      }
    }
    cout << counter << endl;
  }
}