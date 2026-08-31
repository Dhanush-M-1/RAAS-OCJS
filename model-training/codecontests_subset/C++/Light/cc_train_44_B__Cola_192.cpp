#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int ans = 0;
  for (int i = 0; i <= min(a, 2 * n); i += 2) {
    for (int j = 0; j <= min(b, n - i / 2); ++j) {
      int k = min(c, (n - i / 2 - j) / 2);
      if (i / 2 + j + 2 * k == n) ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
