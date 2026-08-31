#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 0, b = 0, f, x1, x2;
  cout << "? " << a << " " << b << endl;
  cin >> f;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << ((1 << i) | a) << " " << b << endl;
    cin >> x1;
    cout << "? " << a << " " << ((1 << i) | b) << endl;
    cin >> x2;
    if (x1 != x2) {
      if (x1 == -1) {
        a += 1 << i;
        b += 1 << i;
      }
    } else {
      if (f == 1)
        a += 1 << i;
      else if (f == -1)
        b += 1 << i;
      f = x1;
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
