#include <bits/stdc++.h>
using namespace std;

int main() {
  int Q;
  cin >> Q;
  
  while ( Q-- ) {
    int n;
    int cnt = 0;
    cin >> n;
    map<int, bool> used;
    while ( 1 ) {      
      if ( used[n] ) {
	cnt = -1;
	break;
      }
      used[n] = true;
      if ( n < 10 ) break;
      cnt++;
      int m = -1;
      for ( int i = 10; ; i *= 10 ) {
	if ( i > n ) break;
	m = max(m, (n/i)*(n%i));
      }      
      n = m;      
    }

    cout << cnt << endl;
  }
  
  return 0;
}

