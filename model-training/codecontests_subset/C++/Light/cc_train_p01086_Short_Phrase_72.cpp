#include <bits/stdc++.h>
using namespace std;

#define int long long

signed main() {
  int n;
  while ( cin >> n, n ) {
    vector<string> w(n);
    for ( int i = 0; i < n; i++ ) cin >> w[i];

    for ( int i = 0; i < n; i++ ) {
      int id = 0;
      vector<int> tanku{5, 7, 5, 7, 7};      
      for ( int j = i; j < n; j++ ) {
	if ( tanku[id] == (int)w[j].size() ) {
	  id++;	  
	} else if ( tanku[id] > (int)w[j].size() ) {
	  tanku[id] -= (int)w[j].size();	  
	} else {
	  break;
	}
	if ( id == 5 ) break;	
      }

      if ( id == 5 ) {
	cout << i+1 << endl;
	break;	
      }
    }
  }

  return 0;
}

