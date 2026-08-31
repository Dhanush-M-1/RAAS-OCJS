#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a = 0, b = 0;
  bool gr = 0;
  cout << "? " << 0 << " " << 0 << endl;
  fflush(stdout);
  int g;
  cin >> g;
  if (g == 1)
    gr = 1;
  else
    gr = 0;
  for (int i = 29; i >= 0; i--) {
    cout << "? " << (a + (1 << i)) << " " << b << endl;
    fflush(stdout);
    int a1, a2;
    cin >> a1;
    cout << "? " << a << " " << (b + (1 << i)) << endl;
    fflush(stdout);
    cin >> a2;
    if (a1 == a2) {
      if (gr) {
        a += (1 << i);
        if (a1 == 1)
          gr = 1;
        else
          gr = 0;
      } else {
        b += (1 << i);
        if (a1 == 1)
          gr = 1;
        else
          gr = 0;
      }
    }
    if (a1 != a2) {
      if (a1 == -1) {
        a += (1 << i);
        b += (1 << i);
      }
    }
  }
  cout << "! " << a << " " << b << endl;
  return 0;
}
