#include <bits/stdc++.h>
using namespace std;
int main() {
  long int x, i, j, k, p, q, m, n, a, s = 0, z[100], u;
  double d;
  cin >> x >> i >> j >> k >> p;
  s = x + i + j + k + p;
  if (x != 0 || i != 0 || j != 0 || k != 0 || p != 0) {
    if ((s % 5) != 0)
      cout << "-1" << endl;
    else
      cout << s / 5 << endl;
  } else
    cout << "-1" << endl;
  return 0;
}
