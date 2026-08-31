#include <bits/stdc++.h>
using namespace std;
int t, n, i;
long long l, r;
void afis(int n, int i, int l, int r) {
  int val = n - i;
  for (int j = l; j <= r; j++) {
    if (j & 1)
      cout << val << ' ';
    else
      cout << val + (j / 2) << ' ';
  }
  return;
}
int main() {
  cin >> t;
  for (; t; t--) {
    cin >> n >> l >> r;
    for (i = n - 1; i >= 1; i--)
      if (l > 2 * i)
        l -= 2 * i, r -= 2 * i;
      else
        break;
    while (i) {
      if (r <= 2 * i) {
        afis(n, i, l, r);
        r = 0;
        break;
      } else {
        afis(n, i, l, 2 * i);
        l = 1, r -= 2 * i;
      }
      i--;
    }
    if (r) cout << 1;
    cout << '\n';
  }
  return 0;
}
