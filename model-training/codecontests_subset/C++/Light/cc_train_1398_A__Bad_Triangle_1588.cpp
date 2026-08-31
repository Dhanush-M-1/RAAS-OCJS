#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  vector<long long int> v(n);
  for (long long int i = 0; i < n; ++i) cin >> v[i];
  if (v[0] + v[1] <= v.back()) {
    cout << "1 2 " << v.size();
    return;
  }
  cout << -1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1, tmp = 0;
  cin >> t;
  while (t--) {
    solve();
    if (t) cout << "\n";
  }
  cerr << "Time : " << (double)clock() / (double)CLOCKS_PER_SEC << "s\n";
  return 0;
}
