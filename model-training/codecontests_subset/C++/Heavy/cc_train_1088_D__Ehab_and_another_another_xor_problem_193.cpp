#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long a1 = 0, b1 = 0, q;
  cout << '?' << ' ' << 0 << ' ' << 0 << endl;
  cin >> q;
  if (q == 0) {
    for (long long i = 29; i >= 0; i--) {
      cout << '?' << ' ' << (1ll << i) << ' ' << 0 << endl;
      cin >> q;
      if (q == -1) {
        a1 |= (1ll << i);
        b1 |= (1ll << i);
      }
    }
    cout << '!' << ' ' << a1 << ' ' << b1 << endl;
    return 0;
  } else {
    long long last = q, g1 = 0, g2 = 0;
    for (long long i = 29; i >= 0; i--) {
      if (last == 0) {
        cout << '?' << ' ' << (g1 | (1ll << i)) << ' ' << g2 << endl;
        cin >> q;
        if (q == -1) {
          a1 |= (1ll << i);
          b1 |= (1ll << i);
        }
        continue;
      }
      cout << '?' << ' ' << (g1 | (1ll << i)) << ' ' << (g2 | (1ll << i))
           << endl;
      cin >> q;
      if (q != last) {
        if (last == 1) {
          a1 |= (1ll << i);
          g2 |= (1ll << i);
          cout << '?' << ' ' << g1 << ' ' << (g2 | (1ll << i)) << endl;
          cin >> q;
          last = q;
        } else if (last == -1) {
          b1 |= (1ll << i);
          g1 |= (1ll << i);
          cout << '?' << ' ' << (g1 | (1ll << i)) << ' ' << g2 << endl;
          cin >> q;
          last = q;
        }
      } else if (q == 1) {
        cout << '?' << ' ' << g1 << ' ' << (g2 | (1ll << i)) << endl;
        cin >> q;
        if (q == 1) {
          a1 |= (1ll << i);
          b1 |= (1ll << i);
        }
      } else if (q == -1) {
        cout << '?' << ' ' << (g1 | (1ll << i)) << ' ' << g2 << endl;
        cin >> q;
        if (q == -1) {
          a1 |= (1ll << i);
          b1 |= (1ll << i);
        }
      }
    }
    cout << '!' << ' ' << a1 << ' ' << b1 << endl;
  }
  return 0;
}
