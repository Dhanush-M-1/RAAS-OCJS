#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<pair<int, int> > v(n);
  for (int i = 0; i < n; i++) cin >> v[i].first >> v[i].second;
  long long int ans = 1;
  int prev = 0;
  for (int i = 1; i < n - 1; i++) {
    if (abs(v[i].first - v[i - 1].first - prev) > v[i].second) {
      ans++;
      prev = 0;
    } else if (abs(v[i + 1].first - v[i].first) > v[i].second) {
      ans++;
      prev = v[i].second;
    } else
      prev = 0;
  }
  if (n > 1) ans++;
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) solve();
  return 0;
}
