#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, ans = 0;
  double now, k;
  cin >> n >> a >> b >> c;
  for (int i = 0; i <= min(n / 2, c); i++) {
    for (int j = 0; j <= min(n, b); j++) {
      now = i * 2.0 + j * 1.0;
      if (now > n) continue;
      k = (n * 1.0 - now) * 2;
      if (k <= a) ans++;
    }
  }
  cout << ans;
  return 0;
}
