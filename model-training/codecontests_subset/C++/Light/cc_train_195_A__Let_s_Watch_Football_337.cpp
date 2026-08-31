#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, l, r, t;
  cin >> a >> b >> c;
  l = 0;
  r = c * a / b;
  while (l <= r) {
    bool f = 1;
    t = (l + r) / 2;
    for (int i = 1; i <= c; i++)
      if (t * b + i * b < i * a) {
        f = 0;
      }
    if (f == 1) r = t - 1;
    if (f == 0) l = t + 1;
  }
  cout << l << endl;
}
