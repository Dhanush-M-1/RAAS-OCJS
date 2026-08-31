#include <bits/stdc++.h>
using namespace std;
void solve();
void precalc();
int main() {
  string s = "change me please";
  int t = 1;
  while (t--) solve();
  return 0;
}
void solve() {
  int n;
  cin >> n;
  vector<int> a(n), h(n);
  for (int i = 0; i < n; ++i) cin >> a[i] >> h[i];
  int ans = 0;
  for (int i = 0; i < n; ++i)
    for (int j = 0; j < n; ++j)
      if (a[i] == h[j]) ++ans;
  cout << ans;
}
