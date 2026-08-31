#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, k, ans = 1000000007;
  cin >> n >> k;
  for (int i = 0; i < n; i++) {
    int first;
    cin >> first;
    if (k % first == 0) ans = min(ans, k / first);
  }
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) solve();
  return 0;
}
