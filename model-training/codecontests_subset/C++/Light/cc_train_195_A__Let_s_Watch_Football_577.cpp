#include <bits/stdc++.h>
using namespace std;
int a, b, c;
bool ok(int x, int t) {
  if (t * b >= (t - x) * a) return 1;
  return 0;
}
int main() {
  cin >> a >> b >> c;
  int x = (a * c) / b;
  int l = 1, r = (c * a + b - 1) / b, t = r, ll;
  while (l <= r) {
    int m = (l + r + 1) / 2;
    if (ok(m, t)) {
      ll = m;
      r = m - 1;
    } else
      l = m + 1;
  }
  cout << ll;
}
