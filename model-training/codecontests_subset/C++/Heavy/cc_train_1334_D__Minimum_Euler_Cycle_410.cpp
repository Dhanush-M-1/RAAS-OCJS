#include <bits/stdc++.h>
using namespace std;
long long t, n, l, r;
void stampa(int x, int y) {
  if (r == 0) return;
  cout << x << " ";
  r--;
  if (x == n && y >= n) return;
  int succ;
  if (y > x) {
    succ = x + (y == n);
  } else {
    if (x == n) {
      succ = y + 1;
    } else {
      succ = x + 1;
    }
  }
  stampa(y, succ);
}
int main() {
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    r = (r - l + 1);
    for (long long i = 1; i <= n; i++) {
      if (l > ((n - i) * 2ll)) {
        l -= ((n - i) * 2ll);
      } else {
        if (l % 2 == 0)
          stampa(i + l / 2, i + ((i + l / 2 == n)));
        else
          stampa(i, i + (l + 1) / 2);
        break;
      }
    }
    if (r > 0) cout << "1";
    cout << "\n";
  }
  return 0;
}
