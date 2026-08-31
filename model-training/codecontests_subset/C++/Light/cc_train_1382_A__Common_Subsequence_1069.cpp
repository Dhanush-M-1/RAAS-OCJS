#include <bits/stdc++.h>
using namespace std;
using ll = long long;
void solve() {
  int n, m;
  cin >> n >> m;
  vector<int> b(m);
  map<int, int> m1;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    m1[x]++;
  }
  for (int i = 0; i < m; i++) {
    cin >> b[i];
  }
  for (auto i : b) {
    if (m1[i]) {
      cout << "YES\n";
      cout << 1 << " " << i << "\n";
      return;
    }
  }
  cout << "NO\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int _;
  cin >> _;
  while (_--) {
    solve();
  }
  return 0;
}
