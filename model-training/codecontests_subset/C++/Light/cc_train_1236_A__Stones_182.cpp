#include <bits/stdc++.h>
using namespace std;
const long long int maxn = 2e5 + 1;
void solve() {
  long long int a, b, c, ans = 0;
  cin >> a >> b >> c;
  while (b > 0 && c > 1) {
    ans += 3;
    b -= 1;
    c -= 2;
  }
  while (b > 1 && a > 0) {
    ans += 3;
    b -= 2;
    a--;
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int T = 1, p = 0;
  cin >> T;
  do {
    solve();
    p++;
  } while (p < T);
  return 0;
}
