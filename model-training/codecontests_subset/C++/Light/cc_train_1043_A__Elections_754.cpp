#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, s = 0, m = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int t;
    cin >> t;
    if (t > m) m = t;
    s += t;
  }
  int ans = (2 * s) / n + 1;
  if (ans < m) ans = m;
  cout << ans << '\n';
  return 0;
}
