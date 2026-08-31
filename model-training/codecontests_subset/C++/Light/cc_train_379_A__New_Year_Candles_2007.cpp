#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, m;
  cin >> n >> m;
  long long ans = 0;
  long long broken = 0;
  while (n > 0) {
    ans++;
    n--;
    broken++;
    if (broken == m) {
      n++;
      broken = 0;
    }
  }
  cout << ans << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  srand(static_cast<unsigned>(time(0)));
  long long t;
  t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
