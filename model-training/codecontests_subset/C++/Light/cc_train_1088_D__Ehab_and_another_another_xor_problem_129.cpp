#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, st, k1, k2, a = 0, b = 0;
  cout << "?"
       << " " << a << " " << b << endl;
  cin >> st;
  for (int i = 29; i >= 0; i--) {
    cout << "?"
         << " " << int(a | (1 << i)) << " " << b << endl;
    cin >> k1;
    cout << "?"
         << " " << b << " " << int(a | (1 << i)) << endl;
    cin >> k2;
    if (k1 == -1 && k2 == 1)
      a |= (1 << i), b |= (1 << i);
    else if (k1 == k2) {
      if (st == 1)
        a |= (1 << i);
      else
        b |= (1 << i);
      st = k1;
    }
  }
  cout << "!"
       << " " << a << " " << b << endl;
}
