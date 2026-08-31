#include <iostream>
using namespace std;

int main() {

  long long int n, input;

  cin >> n;

  for ( long long int i = 0; i < n; i++ ) {

    cin >> input;

    if ( input < 10 ) {
      cout << 0 << endl;
      continue;
    }

    long long int ans = 1;

    while( true ) {

      long long int k = 0;

      for ( long long int j = 10; j <= input; j *= 10 ) {

	k = max( k, ( input / j ) * ( input % j ) );

      }

      input = k;

      if ( input < 10 ) break;

      ans++;

    }

    cout << ans << endl;

  }

  return 0;

}