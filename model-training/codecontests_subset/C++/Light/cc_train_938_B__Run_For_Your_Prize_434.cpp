#include <bits/stdc++.h>
using namespace std;
int n, a[1000000], ans = numeric_limits<int>::max();
void solve() {
  cin >> n;
  a[0] = 1;
  a[n + 1] = 1000000;
  for (int i = int(1); i <= int(n); i++) {
    cin >> a[i];
  }
  for (int i = int(0); i <= int(n); i++) {
    ans = min(ans, max(a[i] - 1, 1000000 - a[i + 1]));
  }
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
