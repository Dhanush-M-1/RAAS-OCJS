#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
const long long INF = 1e7;
signed main() {
  cin.tie(0), ios_base::sync_with_stdio(false);
  ;
  long long fl = 0;
  cout << "? " << 0 << " " << 0 << endl;
  long long x;
  cin >> x;
  if (x == -1) {
    fl = 1;
  }
  long long a = 0, b = 0;
  long long c = 0, d = 0;
  for (long long i = 29; i >= 0; i--) {
    cout << "? " << c + (1 << i) << " " << d + (1 << i) << endl;
    long long x;
    cin >> x;
    if (x == -1 && fl == 0) {
      a += (1 << i);
      cout << "? " << c + (1 << i) << " " << d << endl;
      cin >> x;
      if (x == -1) {
        fl = 1;
      }
      c += (1 << i);
    } else if (x == 1 && fl == 1) {
      b += (1 << i);
      cout << "? " << c << " " << d + (1 << i) << endl;
      cin >> x;
      if (x == 1) {
        fl = 0;
      }
      d += (1 << i);
    } else {
      cout << "? " << c + (1 << i) << " " << d << endl;
      cin >> x;
      if (x == -1) {
        a += (1 << i);
        b += (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
