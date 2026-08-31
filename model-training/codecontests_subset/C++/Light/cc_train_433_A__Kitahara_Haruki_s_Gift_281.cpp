#include <bits/stdc++.h>
using namespace std;
const long long N = 100100, mod = 1e9 + 7, mod2 = 1e9 + 9, mod3 = 998244353,
                sq = 450, base = 727, lg = 30;
long long n, m, x, y, z, w, ans, t;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x;
    x /= 100;
    if (x == 2)
      y++;
    else
      z++;
  }
  for (int i = 0; i <= y; i++) {
    for (int j = 0; j <= z; j++) {
      if (i * 2 + j * 1 == (y - i) * 2 + (z - j) * 1) return cout << "YES", 0;
    }
  }
  cout << "NO";
  return 0;
}
