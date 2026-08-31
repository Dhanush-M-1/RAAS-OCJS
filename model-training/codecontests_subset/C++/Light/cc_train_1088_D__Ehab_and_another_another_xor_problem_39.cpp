#include <bits/stdc++.h>
using namespace std;
int query(int a, int b) {
  cout << "? " << a << " " << b << endl;
  fflush(stdout);
  int x = 0;
  cin >> x;
  return x;
}
int main() {
  int a = 0, b = 0;
  bool f = 1;
  if (query(a, b) < 0) f = 0;
  for (int i = 29; ~i; i--) {
    int x, y;
    x = query(a ^ (1 << i), b);
    y = query(a, b ^ (1 << i));
    if (x == y) {
      if (f)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      f = (x == 1);
    } else if (x == -1 && y == 1) {
      a ^= (1 << i);
      b ^= (1 << i);
    }
  }
  cout << "! " << a << " " << b << endl;
  fflush(stdout);
  return 0;
}
