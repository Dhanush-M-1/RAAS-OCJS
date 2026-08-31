#include <bits/stdc++.h>
using namespace std;
const int MAX = 500 + 7;
const int INF = 1e9;
int s, k, n, m, x, y, p, q, c, d, a, b, caseno = 0, ans = 0, excess = 0;
int MAIN() {
  cin >> a >> b;
  while (a > 0) {
    ans += a;
    a = a + excess;
    excess = a % b;
    a = a / b;
  }
  cout << ans;
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  return MAIN();
}
