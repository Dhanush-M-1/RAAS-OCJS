#include <bits/stdc++.h>
using namespace std;
int a, b, n, g;
int ask(int a, int b) {
  cout << "? " << a << ' ' << b << endl;
  cin >> n;
  return n;
}
int main() {
  g = ask(0, 0);
  for (int i = 29; ~i; --i) {
    int c1 = ask(a ^ (1 << i), b), c2 = ask(a, b ^ (1 << i));
    if (c1 == c2) {
      if (g == 1)
        a |= (1 << i);
      else
        b |= (1 << i);
      g = c1;
    } else if (c1 == -1) {
      a |= (1 << i);
      b |= (1 << i);
    }
  }
  cout << "! " << a << ' ' << b << endl;
  return 0;
}
