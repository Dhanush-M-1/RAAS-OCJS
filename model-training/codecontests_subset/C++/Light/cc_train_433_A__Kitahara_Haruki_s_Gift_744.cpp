#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
void solve() {
  int n;
  cin >> n;
  int a[n];
  int cnt = 0, cnt1 = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] == 100)
      cnt++;
    else
      cnt1++;
  }
  if (cnt & 1) {
    cout << "NO\n";
    return;
  }
  if ((cnt1 & 1) == 0) {
    cout << "YES\n";
    return;
  }
  if (cnt < 2)
    cout << "NO\n";
  else
    cout << "YES\n";
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
}
