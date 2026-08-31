#include <bits/stdc++.h>
using namespace std;
int query(int c, int d) {
  int res;
  cout << "? " << c << ' ' << d << endl;
  fflush(stdout);
  cin >> res;
  return res;
}
int main() {
  int a = 0, b = 0;
  bool op = (query(0, 0) > 0);
  for (int i = 29; i >= 0; i--) {
    int q1 = query(a ^ (1 << i), b), q2 = query(a, b ^ (1 << i));
    if (q1 == q2) {
      if (op == 1)
        a ^= (1 << i);
      else
        b ^= (1 << i);
      op = (q1 == 1);
    } else if (q1 == -1 && q2 == 1) {
      a ^= (1 << i);
      b ^= (1 << i);
    }
  }
  cout << "! " << a << ' ' << b << endl;
  return 0;
}
