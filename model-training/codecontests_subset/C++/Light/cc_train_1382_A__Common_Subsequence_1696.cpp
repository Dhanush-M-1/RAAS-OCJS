#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, m;
  cin >> n >> m;
  bool frq[1001] = {false};
  int val;
  for (int i = 0; i < n; i++) {
    cin >> val;
    frq[val] = true;
  }
  int b[m];
  for (int i = 0; i < m; i++) cin >> b[i];
  for (int i = 0; i < m; i++) {
    if (frq[b[i]]) {
      cout << "YES"
           << "\n"
           << 1 << " " << b[i] << "\n";
      return;
    }
  }
  cout << "NO"
       << "\n";
  return;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
